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

/*Mostra tutti gli eventi che si possono modificare o eliminare*/

@WebServlet(name="ModificaRimuoviEvento", value="/ModificaRimuoviEvento")
public class ModificaRimuoviEvento extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Evento> eventi=new ArrayList<>();
        EventoDAO dao=new EventoDAO();
        eventi= (ArrayList<Evento>) dao.doRetrieveAllEvents();
        request.setAttribute("eventi",eventi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviEvento.jsp");
        dispatcher.forward(request, response);
    }
}
