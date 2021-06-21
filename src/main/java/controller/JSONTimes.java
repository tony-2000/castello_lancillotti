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
import java.sql.Date;
import java.util.ArrayList;

/*Recupera gli orari di un evento da una data*/

@WebServlet("/JSONTimes")
public class JSONTimes extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    public JSONTimes() {
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
        OrarioDAO dao=new OrarioDAO();
        ArrayList<Orario> orari= (ArrayList<Orario>) dao.doRetrieveTimesByEventDate(data,id);
        ArrayList<Orario> orariClone= (ArrayList<Orario>) orari.clone();
        /*rimuove gli orari senza posti disponibili*/
        int count=0;
        for(Orario y: orariClone)
        {
            if(y.getPostiDisponibili()==0)
            {
                orari.remove(y);
            }
        }
        int index=orari.size();
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().append("[");
        for(Orario x:orari)
        {
            count++;
         response.getWriter().append("{\"ora\":\"").append(String.valueOf(x.getOra())).append("\"}");
         if(index>count)
            response.getWriter().append(",");
        }
        response.getWriter().append("]");
    }
}
