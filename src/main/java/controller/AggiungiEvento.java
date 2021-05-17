package controller;

import model.Categoria;
import model.CategoriaDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="AggiungiEvento", value="/AggiungiEvento")
public class AggiungiEvento extends HttpServlet
{
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Categoria> categorie=new ArrayList<>();
        CategoriaDAO temp=new CategoriaDAO();
        categorie= (ArrayList<Categoria>) temp.doRetrieveAllCategories();
        request.setAttribute("categorie",categorie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AggiungiEvento.jsp");
        dispatcher.forward(request, response);
    }

}