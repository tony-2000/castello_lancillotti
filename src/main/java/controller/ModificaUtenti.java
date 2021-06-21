package controller;

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

/*Mostra tutti gli utenti che si possono eliminare o a cui si può cambiare lo stato admin*/

@WebServlet(name="ModificaUtenti", value="/ModificaUtenti")
public class ModificaUtenti extends HttpServlet
{
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        UtenteDAO dao=new UtenteDAO();
        ArrayList<Utente> utenti= (ArrayList<Utente>) dao.doRetrieveAllUsers();
        utenti.removeIf(x->x.getIdUtente()==1);
        utenti.removeIf(x->x.getIdUtente()==user.getIdUtente());
        request.setAttribute("utenti",utenti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaUtenti.jsp");
        dispatcher.forward(request, response);
    }

}