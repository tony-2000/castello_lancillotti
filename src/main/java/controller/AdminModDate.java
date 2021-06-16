package controller;


import model.Data;
import model.DataDAO;
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

@WebServlet(name="AdminModDate", value="/AdminModDate")
public class AdminModDate extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Integer.parseInt(request.getParameter("idEvento"));
        EventoDAO daoEv=new EventoDAO();
        Evento evento=daoEv.doRetrieveEventsByKey(id);
        DataDAO daoDa=new DataDAO();
        ArrayList<Data> date= (ArrayList<Data>) daoDa.doRetrieveDatesByEvent(id);

        request.setAttribute("evento",evento);
        request.setAttribute("date",date);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AdminDate.jsp");
        dispatcher.forward(request, response);


    }

}
