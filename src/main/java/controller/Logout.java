package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="Logout", value="/Logout")
public class Logout extends HttpServlet
    {
        public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            doGet(request,response);
        }

        public void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
            HttpSession session=request.getSession();
            session.removeAttribute("utenteSessione");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }

    }