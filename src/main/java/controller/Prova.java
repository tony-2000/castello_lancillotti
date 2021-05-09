package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;


@WebServlet(name="Prova", urlPatterns = {"/Prova"})
public class Prova extends HttpServlet
    {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            doGet(request, response);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {

            ArrayList<Partecipare> temp=new ArrayList<>();
            PartecipareDAO dao = new PartecipareDAO();
            temp= (ArrayList<Partecipare>) dao.doRetrievePurchases(Integer.parseInt(request.getParameter("x1")));
            for(Partecipare x: temp)
            {
                System.out.println(x.getIdUtente()+"     "+x.getIdEvento()+"   "+ x.getDataPartecipazione()+"   "+x.getOrarioPartecipazione());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/provaStampa.jsp");
            dispatcher.forward(request, response);
        }
    }

/*

Utente x=new Utente();
            x.setNome(request.getParameter("nome"));
            x.setCognome(request.getParameter("cognome"));
            x.setTelefono(request.getParameter("telefono"));
            x.setMail(request.getParameter("mail"));
            x.setNomeUtente(request.getParameter("nomeUtente"));
            x.setPasswordHash(request.getParameter("password"));
            UtenteDAO temp=new UtenteDAO();
            temp.doSave(x);


            Utente y=new Utente();
            y=temp.doRetrieveByUsernamePassword("C","c");
            if(y!=null)
            {
                System.out.println(y.getNomeUtente()+"  "+y.getPassword());
            }
            else System.out.println("Utente non trovato");

            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/provaStampa.jsp");
            dispatcher.forward(request, response);

    List<Recensione> customers=new ArrayList<>();
    RecensioneDAO temp=new RecensioneDAO();
            customers=temp.doRetrieveReviewsByKey(2,20);

                    request.setAttribute("list",customers);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/provaStampa.jsp");
                    dispatcher.forward(request, response);






                    <ul>
    <c:forEach items="${list}" var="customer" >
        <li>${customer.idUtente} &nbsp; ${customer.idEvento} ${customer.commento}
                ${customer.valutazione} &nbsp; ${customer.dataRecensione} ${customer.orarioRecensione}</li>
        <br><br>
    </c:forEach>
</ul>*/
