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

@WebServlet(name="doAggiungiCategoria", value="/doAggiungiCategoria")
public class doAggiungiCategoria extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Categoria cat= new Categoria();
        CategoriaDAO dao=new CategoriaDAO();
        cat.setNome(request.getParameter("nome"));
        cat.setLinkImmagine("cc");
        dao.doSave(cat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AreaAdmin.jsp");
        dispatcher.forward(request, response);
    }
}