package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
@WebServlet(name="ModificaRimuoviCategoria", value="/ModificaRimuoviCategoria")

public class ModificaRimuoviCategoria extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Categoria> cat=new ArrayList<>();
        CategoriaDAO dao=new CategoriaDAO();
        cat= (ArrayList<Categoria>) dao.doRetrieveAllCategories();
        cat.removeIf(x->x.getIdCategoria()==1);
        request.setAttribute("categoria",cat);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviCategoria.jsp");
        dispatcher.forward(request, response);
    }
}
