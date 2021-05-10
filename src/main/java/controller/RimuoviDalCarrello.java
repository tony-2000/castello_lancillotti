package controller;

import model.Partecipare;
import model.PartecipareDAO;
import model.Utente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@WebServlet(name="RimuoviDalCarrello", value="/RimuoviDalCarrello")
public class RimuoviDalCarrello
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        int idEvento= (int) request.getAttribute("id_evento");
        if(session.getAttribute("utente")==null)
        {
            ArrayList<Partecipare> temp= (ArrayList<Partecipare>) session.getAttribute("carrello");
            for(Partecipare x :temp)
            {
                if(x.getIdEvento()==idEvento && x.getIdUtente()==0)
                    temp.remove(x);
            }
            session.setAttribute("carrello",temp);
        }
        else
        {
            Utente user= (Utente) session.getAttribute("utente");
            PartecipareDAO dao=new PartecipareDAO();
            dao.doDelete(user.getIdUtente(),idEvento);
        }
        response.sendRedirect("localhost:8080/Castello_Lancillotti_war_exploded/WEB-INF/results/Carrello");
    }
}


