package controller;

import model.Data;
import model.Orario;
import model.OrarioDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

@WebServlet("/JSONTickets")
public class JSONTickets extends HttpServlet
{
    private static final long serialVersionUID = 2L;

    public JSONTickets() {
        super();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException
    {
        int id=Integer.parseInt(request.getParameter("id"));
        Date data=Date.valueOf(request.getParameter("data"));
        Time ora= Time.valueOf(request.getParameter("ora"));
        OrarioDAO dao= new OrarioDAO();
        int tickets= dao.doRetrieveTimesByKey(ora,data,id).getPostiDisponibili();
        response.setContentType("text/plain;charset=UTF-8");
            response.getWriter().append("{\"ticket\":\"").append(String.valueOf(tickets)).append("\"}");
    }
}
