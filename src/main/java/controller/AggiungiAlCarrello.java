package controller;

import model.Partecipare;
import model.PartecipareDAO;
import model.Utente;

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

@WebServlet(name="AggiungiAlCarrello", value="/AggiungiAlCarrello")
public class AggiungiAlCarrello extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Partecipare prodotto = new Partecipare();
        prodotto.setIdUtente(0);
        prodotto.setIdEvento(Integer.parseInt(request.getParameter("id_evento")));
        prodotto.setQuantitaBiglietti(Integer.parseInt(request.getParameter("quantita_biglietti")));
        prodotto.setDataPartecipazione(Date.valueOf(request.getParameter("data")));
        prodotto.setOrarioPartecipazione(Time.valueOf(request.getParameter("orario")));
        prodotto.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
        HttpSession session = request.getSession();
        if (session.getAttribute("utenteSessione") == null)
        {
            if (session.getAttribute("carrello") == null)
            {
                ArrayList<Partecipare> carrello = new ArrayList<>();
                session.setAttribute("carrello", carrello);
            }
            ArrayList<Partecipare> temp = (ArrayList<Partecipare>) session.getAttribute("carrello");
            ArrayList<Partecipare> scorri= (ArrayList<Partecipare>) temp.clone();

            for (Partecipare x : scorri)
            {
                if (x.getIdEvento() == prodotto.getIdEvento() && x.getDataPartecipazione().equals(prodotto.getDataPartecipazione())
                        && x.getOrarioPartecipazione().equals(prodotto.getOrarioPartecipazione()))
                {
                    int ticket = prodotto.getQuantitaBiglietti() + x.getQuantitaBiglietti();
                    prodotto.setQuantitaBiglietti(ticket);
                    temp.remove(x);
                }
            }
                temp.add(prodotto);
                session.setAttribute("carrello", temp);
        }

        else
            {
            Utente user = (Utente) session.getAttribute("utenteSessione");
            prodotto.setIdUtente(user.getIdUtente());
            PartecipareDAO dao = new PartecipareDAO();
            ArrayList<Partecipare> temp = (ArrayList<Partecipare>) dao.doRetrieveShoppingCart(user.getIdUtente());
            for (Partecipare x : temp) {
               if (x.getIdEvento() == prodotto.getIdEvento() && x.getDataPartecipazione().equals(prodotto.getDataPartecipazione())
                        && x.getOrarioPartecipazione().equals(prodotto.getOrarioPartecipazione()))
                {
                    int ticket = prodotto.getQuantitaBiglietti() + x.getQuantitaBiglietti();
                    prodotto.setQuantitaBiglietti(ticket);
                    dao.doDelete(prodotto.getIdUtente(), prodotto.getIdEvento(), prodotto.getDataPartecipazione(), prodotto.getOrarioPartecipazione(),prodotto.isAcquistato());
                }
            }
                dao.doSave(prodotto);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}


