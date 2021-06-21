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
import java.util.List;

/*Acquistare prodotti dal carrello e reindirizzare al Riepilogo acquisti*/

@WebServlet(name="Acquista", value="/Acquista")
public class Acquista extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int temporal=0;
        String url="/WEB-INF/results/RiepilogoAcquisti.jsp";
        HttpSession session=request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        PartecipareDAO dao=new PartecipareDAO();
        ArrayList<Partecipare> carrello= (ArrayList<Partecipare>) dao.doRetrieveShoppingCart(user.getIdUtente());
        if(carrello.size()==0)
        {
            url="index.jsp";
            /*Controllo gestito dalla jsp, questo risulta come controllo aggiuntivo*/
        }
        else
        {
            OrarioDAO daoTemp=new OrarioDAO();
            PartecipareDAO part=new PartecipareDAO();
            Orario temp=new Orario();
            PartecipareDAO daoPartecipare=new PartecipareDAO();
            ArrayList<Partecipare> acquisti = (ArrayList<Partecipare>) daoPartecipare.doRetrievePurchases(user.getIdUtente());
            for(Partecipare x: carrello)
                /*Gestione di nuovi acquisti di eventi già acquistati in precedenza*/
            {
                temporal=x.getQuantitaBiglietti();
               temp=daoTemp.doRetrieveTimesByKey(x.getOrarioPartecipazione(),x.getDataPartecipazione(),x.getIdEvento());
               for(Partecipare y:acquisti)
               {
                   if(x.getIdEvento()==y.getIdEvento() && x.getIdUtente()==y.getIdUtente()
                           && x.getDataPartecipazione().equals(y.getDataPartecipazione()) && x.getOrarioPartecipazione().equals(y.getOrarioPartecipazione()))
                   {
                       temporal=y.getQuantitaBiglietti()+x.getQuantitaBiglietti();
                       daoPartecipare.doDelete(y.getIdUtente(),y.getIdEvento(),y.getDataPartecipazione(),y.getOrarioPartecipazione(),y.isAcquistato());
                   }
               }
               if(temp.getPostiDisponibili()-x.getQuantitaBiglietti()>=0)
                   /*Controllo aggiuntivo già gestito in 'carrello':disponibilità di posti messi nel carrello.*/
               {
                   temp.setPostiDisponibili(temp.getPostiDisponibili()-x.getQuantitaBiglietti());
                   daoTemp.doUpdate(temp);
                   x.setQuantitaBiglietti(temporal);
                   daoPartecipare.doUpdate(x);
                   x.setAcquistato(true);
                   part.doBuy(x);
               }
               else
               {
                   url="index.jsp";
               }
            }
            /*Caricamento lista di acquisti da mostrare nel riepilogo acquisti. Utilizzo di classe di supporto CartElement
            * per avere informazioni su nome dell'evento e link immagine*/
            ArrayList<Partecipare> lista = (ArrayList<Partecipare>) daoPartecipare.doRetrievePurchases(user.getIdUtente());
            ArrayList<CartElement> cartElements = new ArrayList<>();
            ArrayList<Evento> eventi = new ArrayList<>();
            EventoDAO eventidao = new EventoDAO();
            eventi = (ArrayList<Evento>) eventidao.doRetrieveAllEvents();
            for (Partecipare x : lista) {
                CartElement temps = new CartElement();
                temps.setAcquistato(x.isAcquistato());
                temps.setDataPartecipazione(x.getDataPartecipazione());
                temps.setOrarioPartecipazione(x.getOrarioPartecipazione());
                temps.setIdEvento(x.getIdEvento());
                temps.setIdUtente(x.getIdUtente());
                temps.setPrezzo(x.getPrezzo());
                temps.setQuantitaBiglietti(x.getQuantitaBiglietti());
                for (Evento y : eventi) {
                    if (temps.getIdEvento() == y.getIdEvento())
                    {
                        temps.setNome(y.getNome());
                        temps.setLink(y.getLinkImmagine());
                    }
                }
                cartElements.add(temps);
            }
            request.setAttribute("lista",cartElements);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
}