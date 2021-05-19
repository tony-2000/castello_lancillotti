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

@WebServlet(name="EliminaRecensione", value="/EliminaRecensione")
public class EliminaRecensione extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
    {
        int idEvento=Integer.parseInt(request.getParameter("idEvento"));
        HttpSession session= request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        int idUtente=user.getIdUtente();
        RecensioneDAO dao= new RecensioneDAO();
        dao.doDelete(idUtente,idEvento);


        EventoDAO eventdao = new EventoDAO();
        Evento event = new Evento();
        event = eventdao.doRetrieveEventsByKey(idEvento);
        request.setAttribute("evento", event);

        ArrayList<Recensione> list = new ArrayList<>();
        RecensioneDAO recensioneDAO = new RecensioneDAO();
        list = (ArrayList<Recensione>) recensioneDAO.doRetrieveReviewsByEvent(idEvento);
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
            RecensioneSupport rec=new RecensioneSupport();
            rec.setIdEvento(x.getIdEvento());
            rec.setCommento(x.getCommento());
            rec.setDataRecensione(x.getDataRecensione());
            rec.setValutazione(x.getValutazione());
            rec.setIdUtente(x.getIdUtente());
            rec.setOrarioRecensione(x.getOrarioRecensione());
            support.add(rec);
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
        request.setAttribute("checkRecensione",checkRecensione);
        request.setAttribute("recensioni",support);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/VisualizzaElemento.jsp");
        dispatcher.forward(request, response);
    }
}