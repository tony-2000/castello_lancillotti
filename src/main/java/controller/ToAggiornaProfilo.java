package controller;

import model.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*Controlla la password e reidirizza alla modifica delle informazioni del profilo*/

@WebServlet(name="ToAggiornaProfilo", value="/ToAggiornaProfilo")
public class ToAggiornaProfilo extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            boolean pass=true;
            String url ="/WEB-INF/results/Profilo.jsp";
            HttpSession session=request.getSession();
            Utente utente= (Utente) session.getAttribute("utenteSessione");
            Utente temp=new Utente();
            temp.setPasswordHash(request.getParameter("password"));
            if(utente.getPassword().equals(temp.getPassword()))
            {
                url="/WEB-INF/results/AggiornaProfilo.jsp";
                pass=false;
            }
            /*alert per password non valida*/
            request.setAttribute("passError",pass);
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            doPost(request, response);


        }
    }
