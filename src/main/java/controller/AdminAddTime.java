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

/*Servlet che aggiunge un orario ad una data*/

@WebServlet(name="AdminAddTime", value="/AdminAddTime")
public class AdminAddTime extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int id=Integer.parseInt(request.getParameter("idEvento"));
        OrarioDAO dao=new OrarioDAO();
        Orario temp=new Orario();
        temp.setIdEvento(id);
        temp.setOra(Time.valueOf(request.getParameter("newHour")));
        temp.setPostiDisponibili(Integer.parseInt(request.getParameter("biglietti")));
        temp.setData(Date.valueOf(request.getParameter("dataEvento")));

        DataDAO datadao=new DataDAO();
        EventoDAO daoEv=new EventoDAO();
        Evento evento=daoEv.doRetrieveEventsByKey(id);
        ArrayList<Orario> orari= (ArrayList<Orario>) dao.doRetrieveTimesByEventDate(temp.getData(),id);

        int cont=3;
        for(Orario x: orari)
        {
            /*Controllo se orario già presente per quella data*/
            if (x.getOra().equals(temp.getOra()))
            {
                cont=-3;
                break;
            }

        }
        if(cont==3)
            dao.doSave(temp);
        /*control per alert in funzione JavaScript*/

        ArrayList<Data> date= (ArrayList<Data>) datadao.doRetrieveDatesByEvent(id);
        request.setAttribute("control",cont);
        request.setAttribute("evento",evento);
        request.setAttribute("date",date);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AdminDate.jsp");
        dispatcher.forward(request, response);
    }

}