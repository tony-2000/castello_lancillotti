package controller;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="Login", value="/Login")
public class Login extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        boolean log=false;
        String resp="/index.jsp";
        String username = request.getParameter("nome_utente");
        String password = request.getParameter("password");
        UtenteDAO x= new UtenteDAO();
        Utente user=x.doRetrieveByUsernamePassword(username,password);
        HttpSession session=request.getSession();
        if(user==null)
        {
            resp="Login.jsp";
            log=true;
        }
        else
            session.setAttribute("utenteSessione",user);
        request.setAttribute("logError",log);
        RequestDispatcher dispatcher = request.getRequestDispatcher(resp);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { }
}
