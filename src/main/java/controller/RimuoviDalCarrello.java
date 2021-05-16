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

@WebServlet(name="RimuoviDalCarrello", value="/RimuoviDalCarrello")
public class RimuoviDalCarrello extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        int idEvento= Integer.parseInt((String) request.getParameter("id_evento"));
        if(session.getAttribute("utenteSessione")==null)
        {
            ArrayList<Partecipare> temp= (ArrayList<Partecipare>) session.getAttribute("carrello");
            if(temp.size()==1)
                temp.remove(0);
            else
            {
                for(Partecipare x :temp)
                {
                    if(x.getIdEvento()==idEvento && x.getIdUtente()==0)
                        temp.remove(x);
                }
            }
            session.setAttribute("carrello",temp);
        }
        else
        {
            Utente user= (Utente) session.getAttribute("utenteSessione");
            PartecipareDAO dao=new PartecipareDAO();
            dao.doDelete(user.getIdUtente(),idEvento);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}


