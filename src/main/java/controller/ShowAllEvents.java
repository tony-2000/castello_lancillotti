package controller;

import model.Categoria;
import model.CategoriaDAO;
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

/*Mostra tutti gli eventi di una categoria*/

@WebServlet(name="ShowAllEvents", value="/ShowAllEvents")
public class ShowAllEvents extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url="/WEB-INF/results/VisualizzaEventi.jsp";
        EventoDAO dao = new EventoDAO();
        int id=Integer.parseInt(request.getParameter("idCategoria"));
        ArrayList<Evento> lista = (ArrayList<Evento>) dao.doRetrieveEventsByCatId(id);
        request.setAttribute("listaEventi", lista);

        CategoriaDAO catdao=new CategoriaDAO();
        String nome=catdao.doRetrieveCategoriesByKey(id).getNome();
        request.setAttribute("nomeCat", nome);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

