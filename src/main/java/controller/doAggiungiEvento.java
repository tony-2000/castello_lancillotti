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

    @WebServlet(name="doAggiungiEvento", value="/doAggiungiEvento")
    public class doAggiungiEvento extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            Evento event= new Evento();
            EventoDAO dao=new EventoDAO();
            event.setIdCategoria(Integer.parseInt(request.getParameter("categorie")));
            event.setNome(request.getParameter("nome"));
            event.setDescrizione(request.getParameter("descrizione"));
            event.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
            event.setPostiDisponibili(Integer.parseInt(request.getParameter("posti")));
            event.setLinkImmagine("cc");
            dao.doSave(event);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AreaAdmin.jsp");
            dispatcher.forward(request, response);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            doPost(request, response);
        }
    }