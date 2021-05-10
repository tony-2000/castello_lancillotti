package controller;

import model.Partecipare;
import model.PartecipareDAO;
import model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@WebServlet(name="RiepilogoAcquisti", value="/RiepilogoAcquisti")
public class RiepilogoAcquisti
{
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            doGet(request, response);
        }


        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            HttpSession session=request.getSession();
            if(session.getAttribute("utente")==null)
            {
                boolean temp= false;
                request.setAttribute("accessoAcquisti",temp);
                response.sendRedirect("http://localhost:8080/Castello_Lancillotti_war_exploded/WEB-INF/results/Login.jsp");
            }
            else
            {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/RiepilogoAcquisti.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
