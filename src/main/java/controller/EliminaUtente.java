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

/*Elimina un utente dal database*/

@WebServlet(name="EliminaUtente", value="/EliminaUtente")
public class EliminaUtente extends HttpServlet
{
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        UtenteDAO dao=new UtenteDAO();
        int id=Integer.parseInt(request.getParameter("idUtente"));
        dao.doDelete(id);
        HttpSession session=request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        ArrayList<Utente> utenti= (ArrayList<Utente>) dao.doRetrieveAllUsers();
        /*Non si può eliminare il primo utente admin (superiore) e l'utente in sessione*/
        utenti.removeIf(x->x.getIdUtente()==1);
        utenti.removeIf(x->x.getIdUtente()==user.getIdUtente());
        request.setAttribute("utenti",utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaUtenti.jsp");
        dispatcher.forward(request, response);

    }

}