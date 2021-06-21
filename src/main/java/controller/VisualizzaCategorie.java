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

/*Visualizza tutte le categorie*/

@WebServlet(name = "VisualizzaCategorie", value = "/VisualizzaCategorie")
public class VisualizzaCategorie extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url="/WEB-INF/results/VisualizzaCategorie.jsp";
        CategoriaDAO dao = new CategoriaDAO();
        ArrayList<Categoria> lista = (ArrayList<Categoria>) dao.doRetrieveAllCategories();
        lista.removeIf(x->x.getIdCategoria()==1);
        request.setAttribute("listaCategorie", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

}

