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


@WebServlet(name="MostraEvento", value="/MostraEvento")
public class MostraEvento extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
    {
        int id=Integer.parseInt(request.getParameter("idEvento"));
        EventoDAO temp=new EventoDAO();
        Evento event=new Evento();
        event=temp.doRetrieveEventsByKey(id);
        request.setAttribute("evento", event);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/VisualizzaElemento.jsp");
        dispatcher.forward(request, response);

    }
}


//  DataDAO dao=new DataDAO();
//        ArrayList<Data> date= (ArrayList<Data>) dao.doRetrieveDatesByEvent(id);
//Usare in questa servlet(forse)


//  OrarioDAO dao=new OrarioDAO();
//        ArrayList<Orario> ora= (ArrayList<Orario>) dao.doRetrieveHoursByEventDate(id);
//Usare in Jsp con ajax;