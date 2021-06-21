package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/*Cambia lo stato di un utente (si può accedere a questa servlet solo lato admin).*/

@WebServlet(name="CambiaStatoAdmin", value="/CambiaStatoAdmin")
public class CambiaStatoAdmin extends HttpServlet
{
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UtenteDAO dao=new UtenteDAO();
        int id=Integer.parseInt(request.getParameter("idUtente"));
        Utente utente=dao.doRetrieveUsersByKey(id);
        boolean admin=utente.isAmministratore();
        if(admin)
            dao.doRemoveAdmin(utente);
        if(!admin)
            dao.doAddAdmin(utente);
        HttpSession session=request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        ArrayList<Utente> utenti= (ArrayList<Utente>) dao.doRetrieveAllUsers();
        /*Non si può cambiare lo stato del primo utente admin (superiore) e dell'utente in sessione*/
        utenti.removeIf(x->x.getIdUtente()==1);
        utenti.removeIf(x->x.getIdUtente()==user.getIdUtente());
        request.setAttribute("utenti",utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaUtenti.jsp");
        dispatcher.forward(request, response);

    }

}