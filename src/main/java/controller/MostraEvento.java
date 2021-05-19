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

        ArrayList<Recensione> list=new ArrayList<>();
        RecensioneDAO dao= new RecensioneDAO();
        list= (ArrayList<Recensione>) dao.doRetrieveReviewsByEvent(id);
        boolean checkRecensione=false;
        HttpSession session=request.getSession();
        if(session.getAttribute("utenteSessione")!=null)
        {
            Utente user = (Utente) session.getAttribute("utenteSessione");
            int idUtente = user.getIdUtente();
            if (dao.doRetrieveReviewsByKey(idUtente, event.getIdEvento()) != null)
                checkRecensione = true;
            if (checkRecensione) {
                for (Recensione x : list) {
                    if (x.getIdUtente() == idUtente)
                        Collections.swap(list, 0, list.indexOf(x));
                }

            }
        }
        request.setAttribute("checkRecensione",checkRecensione);
        request.setAttribute("recensioni",list);
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