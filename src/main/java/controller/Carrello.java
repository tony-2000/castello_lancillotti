package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="Carrello", value="/Carrello")
public class Carrello extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        if(session.getAttribute("utente")==null)
        {
            if(session.getAttribute("carrello")==null)
            {
                ArrayList<Partecipare> carrello=new ArrayList<>();
                session.setAttribute("carrello",carrello);
            }

            ArrayList<Partecipare> carrello= (ArrayList<Partecipare>) session.getAttribute("carrello");
            request.setAttribute("carrello",carrello);
        }
        else
        {
            Utente utente = (Utente) session.getAttribute("utente");
            PartecipareDAO dao=new PartecipareDAO();
            ArrayList<Partecipare> carrello= (ArrayList<Partecipare>) dao.doRetrieveShoppingCart(utente.getIdUtente());
            request.setAttribute("carrello",carrello);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/Carrello.jsp");
        dispatcher.forward(request, response);
    }
}
