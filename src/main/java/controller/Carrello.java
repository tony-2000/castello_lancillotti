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
import java.util.Objects;

@WebServlet(name="Carrello", value="/Carrello")
public class Carrello extends HttpServlet
{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ArrayList<Partecipare> cart=new ArrayList<>();
        HttpSession session=request.getSession();
        if(session.getAttribute("utenteSessione")==null)
        {
            if(session.getAttribute("carrello")==null)
            {
                ArrayList<Partecipare> carrello=new ArrayList<>();
                session.setAttribute("carrello",carrello);
                cart= carrello;
            }

            ArrayList<Partecipare> carrello= (ArrayList<Partecipare>) session.getAttribute("carrello");
            cart= carrello;
        }
        else
        {
            Utente utente = (Utente) session.getAttribute("utenteSessione");
            PartecipareDAO dao=new PartecipareDAO();
            List<Partecipare> carrello= dao.doRetrieveShoppingCart(utente.getIdUtente());
            cart= (ArrayList<Partecipare>) carrello;
            boolean checkBiglietti=true;
            boolean checkData=true;
            boolean checkOra=true;
            OrarioDAO orariodao=new OrarioDAO();
            Orario orario=new Orario();
            ArrayList<Partecipare> tempcart= (ArrayList<Partecipare>) cart.clone();
            for(Partecipare x:tempcart)
            {
                orario=orariodao.doRetrieveTimesByKey(x.getOrarioPartecipazione(),x.getDataPartecipazione(),x.getIdEvento());
                if(x.getQuantitaBiglietti()>orario.getPostiDisponibili())
                {
                    checkBiglietti=false;
                    dao.doDelete(x.getIdUtente(),x.getIdEvento(),x.getDataPartecipazione(),x.getOrarioPartecipazione());
                    cart.remove(x);
                }
                else if(System.currentTimeMillis()>orario.getData().getTime())
                {
                    checkData=false;
                    dao.doDelete(x.getIdUtente(),x.getIdEvento(),x.getDataPartecipazione(),x.getOrarioPartecipazione());
                    cart.remove(x);
                }
            }
        }
        ArrayList<CartElement> cartElements=new ArrayList<>();
        ArrayList<Evento> eventi=new ArrayList<>();
        EventoDAO eventidao=new EventoDAO();
        eventi= (ArrayList<Evento>) eventidao.doRetrieveAllEvents();
        for(Partecipare x: cart)
        {
            CartElement temp= new CartElement();
            temp.setAcquistato(x.isAcquistato());
            temp.setDataPartecipazione(x.getDataPartecipazione());
            temp.setOrarioPartecipazione(x.getOrarioPartecipazione());
            temp.setIdEvento(x.getIdEvento());
            temp.setIdUtente(x.getIdUtente());
            temp.setPrezzo(x.getPrezzo());
            temp.setQuantitaBiglietti(x.getQuantitaBiglietti());
            for(Evento y:eventi)
            {
                if(temp.getIdEvento()==y.getIdEvento())
                {
                    temp.setNome(y.getNome());
                    temp.setLink(y.getLinkImmagine());
                }
            }
            cartElements.add(temp);
        }
        request.setAttribute("carrello",cartElements);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/Carrello.jsp");
        dispatcher.forward(request, response);
    }
}
