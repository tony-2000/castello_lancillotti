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
import java.sql.Date;
import java.util.ArrayList;

@WebServlet(name="AdminAddData", value="/AdminAddData")
public class AdminAddData extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Integer.parseInt(request.getParameter("idEvento"));
        DataDAO dao=new DataDAO();
        Data temp=new Data();
        temp.setIdEvento(id);
        temp.setData(Date.valueOf(request.getParameter("newData")));


        EventoDAO daoEv=new EventoDAO();
        Evento evento=daoEv.doRetrieveEventsByKey(id);
        ArrayList<Data> date= (ArrayList<Data>) dao.doRetrieveDatesByEvent(id);
        int cont=1;
        boolean control=false;
        for(Data x: date)
        {
            if (x.getData().equals(temp.getData()))
            {
                control = true;
                cont=-1;
                break;
            }

        }
        if(!control)
            dao.doSave(temp);

        date= (ArrayList<Data>) dao.doRetrieveDatesByEvent(id);
        request.setAttribute("control",cont);
        request.setAttribute("evento",evento);
        request.setAttribute("date",date);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AdminDate.jsp");
        dispatcher.forward(request, response);
    }

}