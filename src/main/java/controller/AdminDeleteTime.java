package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/*Servlet per eliminare un orario da una specifica data*/

@WebServlet(name="AdminDeleteTime", value="/AdminDeleteTime")
public class AdminDeleteTime extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Integer.parseInt(request.getParameter("idEvento"));
        Time ora=Time.valueOf(request.getParameter("orario"));
        Date data=Date.valueOf(request.getParameter("dataEl"));
        DataDAO dao=new DataDAO();
        OrarioDAO orariodao=new OrarioDAO();
        orariodao.doDelete(ora,data,id);

        EventoDAO daoEv=new EventoDAO();
        Evento evento=daoEv.doRetrieveEventsByKey(id);
        ArrayList<Data> date= (ArrayList<Data>) dao.doRetrieveDatesByEvent(id);

        int control=4;
        /*control per alert in funzione javaScript*/

        request.setAttribute("control",control);
        request.setAttribute("evento",evento);
        request.setAttribute("date",date);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AdminDate.jsp");
        dispatcher.forward(request, response);
    }
}