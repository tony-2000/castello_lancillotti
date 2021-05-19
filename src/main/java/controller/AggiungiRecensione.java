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
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@WebServlet(name="AggiungiRecensione", value="/AggiungiRecensione")
public class AggiungiRecensione extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
    {
       String url="/WEB-INF/results/VisualizzaElemento.jsp";
        HttpSession session=request.getSession();
        if(session.getAttribute("utenteSessione")==null)
            url="Login.jsp";
        else
        {
            Utente user= (Utente) session.getAttribute("utenteSessione");
            int idUtente=user.getIdUtente();
            int idEvento=Integer.parseInt(request.getParameter("idEvento"));
            int valutazione=Integer.parseInt(request.getParameter("valutazione"));
            String commento=request.getParameter("commento");
            long temp=System.currentTimeMillis();
            Date data= new Date(temp);
            Time ora= new Time(temp);
            RecensioneDAO dao=new RecensioneDAO();
            Recensione rec=new Recensione();
            rec.setOrarioRecensione(ora);
            rec.setDataRecensione(data);
            rec.setValutazione(valutazione);
            rec.setCommento(commento);
            rec.setIdEvento(idEvento);
            rec.setIdUtente(idUtente);
            dao.doSave(rec);
        }
        int id=Integer.parseInt(request.getParameter("idEvento"));
        EventoDAO temp=new EventoDAO();
        Evento event=new Evento();
        event=temp.doRetrieveEventsByKey(id);
        request.setAttribute("evento", event);

        ArrayList<Recensione> list=new ArrayList<>();
        RecensioneDAO dao= new RecensioneDAO();
        list= (ArrayList<Recensione>) dao.doRetrieveReviewsByEvent(id);
        request.setAttribute("recensioni",list);

        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}