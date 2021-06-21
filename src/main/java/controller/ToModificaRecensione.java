package controller;

import model.Recensione;
import model.RecensioneDAO;
import model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*Reindirizza alla pagina di modifica della recensione*/

@WebServlet(name="ToModificaRecensione", value="/ToModificaRecensione")
public class ToModificaRecensione extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
    {
        int idEvento=Integer.parseInt(request.getParameter("idEvento"));
        HttpSession session=request.getSession();
        Utente user = (Utente) session.getAttribute("utenteSessione");
        int idUtente = user.getIdUtente();
        RecensioneDAO dao=new RecensioneDAO();
        Recensione temp=new Recensione();
        temp=dao.doRetrieveReviewsByKey(idUtente,idEvento);
        request.setAttribute("idEvento", idEvento);
        request.setAttribute("recensione", temp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRecensione.jsp");
        dispatcher.forward(request, response);
    }
}