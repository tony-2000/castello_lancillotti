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
import java.util.Collections;

@WebServlet(name="ToModificaCategoria", value="/ToModificaCategoria")

public class ToModificaCategoria extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        CategoriaDAO dao=new CategoriaDAO();
        Categoria categoria=dao.doRetrieveCategoriesByKey(Integer.parseInt(request.getParameter("idCategoria")));
        request.setAttribute("categoria",categoria);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaCategoria.jsp");
        dispatcher.forward(request, response);
    }
}
