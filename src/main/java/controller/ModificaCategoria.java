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
@WebServlet(name="ModificaCategoria", value="/ModificaCategoria")

public class ModificaCategoria extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Categoria categoria=new Categoria();
        CategoriaDAO dao=new CategoriaDAO();
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        categoria.setNome(request.getParameter("nome"));
        if(request.getParameter("linkImmagine")!=null && request.getParameter("linkImmagine")!="")
            categoria.setLinkImmagine(request.getParameter("linkImmagine"));
        else
            categoria.setLinkImmagine(request.getParameter("link"));
        dao.doUpdate(categoria);
        ArrayList<Categoria> categorie= (ArrayList<Categoria>) dao.doRetrieveAllCategories();
        categorie.removeIf(x->x.getIdCategoria()==1);
        request.setAttribute("categoria",categorie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviCategoria.jsp");
        dispatcher.forward(request, response);
    }
}
