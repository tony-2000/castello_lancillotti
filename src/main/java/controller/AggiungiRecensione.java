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
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/*Aggiunge una recensione ad un prodotto*/

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
            /*Controllo aggiuntivo già gestito nella jsp*/
            url="Login.jsp";
        else
            {
            Utente user = (Utente) session.getAttribute("utenteSessione");
            int idUtente = user.getIdUtente();
            int idEvento = Integer.parseInt(request.getParameter("idEvento"));
            int valutazione = Integer.parseInt(request.getParameter("valutazione"));
            String commento = request.getParameter("commento");
            long temp = System.currentTimeMillis();
            Date data = new Date(temp);
            Time ora = new Time(temp);
            RecensioneDAO dao = new RecensioneDAO();
            Recensione rec = new Recensione();
            rec.setOrarioRecensione(ora);
            rec.setDataRecensione(data);
            rec.setValutazione(valutazione);
            rec.setCommento(commento);
            rec.setIdEvento(idEvento);
            rec.setIdUtente(idUtente);
            dao.doSave(rec);

                /*Carica le informazioni neccesarie per reindirizzare alla jsp. Per ulteriori informazioni andare alla
                * servlet MostraEvento*/

            int id = Integer.parseInt(request.getParameter("idEvento"));
            EventoDAO eventdao = new EventoDAO();
            Evento event = new Evento();
            event = eventdao.doRetrieveEventsByKey(id);
            request.setAttribute("evento", event);

            ArrayList<Recensione> list = new ArrayList<>();
            RecensioneDAO recensioneDAO = new RecensioneDAO();
            list = (ArrayList<Recensione>) recensioneDAO.doRetrieveReviewsByEvent(id);
            boolean checkRecensione = false;
            if (session.getAttribute("utenteSessione") != null) {
                if (dao.doRetrieveReviewsByKey(idUtente, event.getIdEvento()).getIdUtente() > 0)
                    checkRecensione = true;
                if (checkRecensione) {
                    for (Recensione x : list) {
                        if (x.getIdUtente() == idUtente)
                            Collections.swap(list, 0, list.indexOf(x));
                    }

                }
            }
            ArrayList<RecensioneSupport> support=new ArrayList<>();
            for(Recensione x: list)
            {
                RecensioneSupport rece=new RecensioneSupport();
                rece.setIdEvento(x.getIdEvento());
                rece.setCommento(x.getCommento());
                rece.setDataRecensione(x.getDataRecensione());
                rece.setValutazione(x.getValutazione());
                rece.setIdUtente(x.getIdUtente());
                rece.setOrarioRecensione(x.getOrarioRecensione());
                support.add(rece);
            }

            UtenteDAO daoUtente=new UtenteDAO();
            ArrayList<Utente> listUtenti= (ArrayList<Utente>) daoUtente.doRetrieveAllUsers();
            for(RecensioneSupport x: support)
            {
                for(Utente y:listUtenti)
                {
                    if(x.getIdUtente()==y.getIdUtente())
                        x.setNome(y.getNomeUtente());
                }
            }

            if(session.getAttribute("utenteSessione")!=null)
            {
                if(checkRecensione)
                {
                    support.get(0).setNome("Questa è la tua recensione: "+support.get(0).getNome());
                }
            }


            boolean bol;
            DataDAO daodata=new DataDAO();
            ArrayList<Data> date= (ArrayList<Data>) daodata.doRetrieveDatesByEvent(id);
            ArrayList<Data> copy= (ArrayList<Data>) date.clone();
            GregorianCalendar actual=new GregorianCalendar();
            actual.setTimeZone(TimeZone.getTimeZone("Europe/Rome"));
            for(Data x: copy) {
                if (x.getData().getTime() < actual.getTimeInMillis())
                    date.remove(x);
                else {
                    bol=false;
                    OrarioDAO oradao = new OrarioDAO();
                    ArrayList<Orario> orari = (ArrayList<Orario>) oradao.doRetrieveTimesByEventDate(x.getData(), x.getIdEvento());
                    for(Orario z: orari)
                    {
                        if(z.getPostiDisponibili()!=0)
                            bol=true;
                    }
                    if(!bol)
                        date.remove(x);
                    if (orari.size() == 0)
                    {
                        date.remove(x);
                    }
                }
            }

            request.setAttribute("date",date);
            request.setAttribute("checkRecensione",checkRecensione);
            request.setAttribute("recensioni",support);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }
}