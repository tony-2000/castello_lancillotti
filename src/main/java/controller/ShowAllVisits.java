package controller;

import model.Evento;
import model.EventoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*Mostra tutte le visite*/

@WebServlet(name="ShowAllVisits", value="/ShowAllVisits")
public class ShowAllVisits extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url="/WEB-INF/results/VisualizzaVisite.jsp";
        EventoDAO dao = new EventoDAO();
        ArrayList<Evento> lista = (ArrayList<Evento>) dao.doRetrieveEventsByCatId(1);
        request.setAttribute("listaVisite", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

