package controller;

import model.Utente;
import model.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login
{
    @WebServlet(name="Login", urlPatterns = {"/Login"})
    public class LoginServlet extends HttpServlet
    {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            boolean log=true;
            String resp="http://localhost:8080/Castello_Lancillotti_war_exploded/";
            String username = request.getParameter("nome_utente");
            String password = request.getParameter("password");
            UtenteDAO x= new UtenteDAO();
            Utente user=new Utente();
            user=x.doRetrieveByUsernamePassword(username,password);
            HttpSession session=request.getSession();
            if(user==null)
            {
                resp="http://localhost:8080/Castello_Lancillotti_war_exploded/WEB-INF/results/Login.jsp";
                log=false;
                request.setAttribute("logError",log);
            }
            else
                session.setAttribute("utente",user);
            response.sendRedirect(resp);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        { }

    }
}

