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
@WebServlet(name="ModificaEvento", value="/ModificaEvento")

public class ModificaEvento extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Evento evento=new Evento();
        EventoDAO dao=new EventoDAO();
        evento.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
        evento.setIdCategoria(Integer.parseInt(request.getParameter("cate")));
        evento.setNome(request.getParameter("nome"));
        evento.setDescrizione(request.getParameter("descrizione"));
        evento.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
        if(request.getParameter("linkImmagine")!=null && request.getParameter("linkImmagine")!="")
            evento.setLinkImmagine(request.getParameter("linkImmagine"));
        else
            evento.setLinkImmagine(request.getParameter("link"));
        dao.doUpdate(evento);
        ArrayList<Evento> eventi=new ArrayList<>();
        eventi= (ArrayList<Evento>) dao.doRetrieveAllEvents();
        request.setAttribute("eventi",eventi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviEvento.jsp");
        dispatcher.forward(request, response);
    }
}
