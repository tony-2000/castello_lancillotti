package controller;

import model.Categoria;
import model.CategoriaDAO;
import model.Evento;
import model.EventoDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name="ShowAll", value="/ShowAll")
public class ShowAll
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url="/WEB-INF/results/VisualizzaEventi.jsp";
        int id=Integer.parseInt(request.getParameter("id_categoria"));
        List<Evento> temp = new ArrayList<>();
        EventoDAO dao = new EventoDAO();
        List<Evento> lista = dao.doRetrieveEventsByCatId(id);
        if(id==1)
        {
            url="/WEB-INF/results/VisualizzaVisite.jsp";
        }
        request.setAttribute("lista", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

