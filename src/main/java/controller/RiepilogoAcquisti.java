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
import java.util.List;

@WebServlet(name="RiepilogoAcquisti", value="/RiepilogoAcquisti")
public class RiepilogoAcquisti extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String url="/WEB-INF/results/RiepilogoAcquisti.jsp";
        HttpSession session=request.getSession();
        if(session.getAttribute("utenteSessione")==null)
        {
            boolean temp= false;
            request.setAttribute("accessoAcquisti",temp);
            url="Login.jsp";
        }
        else
            {
            ArrayList<Partecipare> lista = new ArrayList<>();
            Utente utente = (Utente) session.getAttribute("utenteSessione");
            PartecipareDAO dao = new PartecipareDAO();
            List<Partecipare> acquisti = dao.doRetrievePurchases(utente.getIdUtente());
            lista = (ArrayList<Partecipare>) acquisti;
            ArrayList<CartElement> cartElements = new ArrayList<>();
            ArrayList<Evento> eventi = new ArrayList<>();
            EventoDAO eventidao = new EventoDAO();
            eventi = (ArrayList<Evento>) eventidao.doRetrieveAllEvents();
            for (Partecipare x : lista) {
                CartElement temp = new CartElement();
                temp.setAcquistato(x.isAcquistato());
                temp.setDataPartecipazione(x.getDataPartecipazione());
                temp.setOrarioPartecipazione(x.getOrarioPartecipazione());
                temp.setIdEvento(x.getIdEvento());
                temp.setIdUtente(x.getIdUtente());
                temp.setPrezzo(x.getPrezzo());
                temp.setQuantitaBiglietti(x.getQuantitaBiglietti());
                for (Evento y : eventi) {
                    if (temp.getIdEvento() == y.getIdEvento())
                    {
                        temp.setNome(y.getNome());
                        temp.setLink(y.getLinkImmagine());
                    }
                }
                cartElements.add(temp);
            }
                request.setAttribute("lista",cartElements);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}

