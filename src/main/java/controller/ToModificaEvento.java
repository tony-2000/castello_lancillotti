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

@WebServlet(name="ToModificaEvento", value="/ToModificaEvento")

public class ToModificaEvento extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        EventoDAO dao=new EventoDAO();
        Evento evento=dao.doRetrieveEventsByKey(Integer.parseInt(request.getParameter("idEvento")));
        request.setAttribute("evento",evento);

        ArrayList<Categoria> categorie=new ArrayList<>();
        CategoriaDAO temp=new CategoriaDAO();
        categorie= (ArrayList<Categoria>) temp.doRetrieveAllCategories();
        request.setAttribute("categorie",categorie);
        for(Categoria x: categorie)
        {
            if(x.getIdCategoria()==evento.getIdCategoria())
                Collections.swap(categorie,0,categorie.indexOf(x));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaEvento.jsp");
        dispatcher.forward(request, response);
    }
}
