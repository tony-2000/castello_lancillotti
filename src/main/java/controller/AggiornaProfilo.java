package controller;

import model.Check;
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

@WebServlet(name="AggiornaProfilo", value="/AggiornaProfilo")
public class AggiornaProfilo extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session=request.getSession();
        Utente user= (Utente) session.getAttribute("utenteSessione");
        String nome=request.getParameter("nome");
        String cognome=request.getParameter("cognome");
        String mail=request.getParameter("mail");
        String nomeUtente=request.getParameter("nomeUtente");
        String telefono=request.getParameter("telefono");
        String password=request.getParameter("password");
        String passwordCheck=request.getParameter("passwordCheck");
        if(Check.nameIsValid(nome)==0)
            user.setNome(nome);
        if(Check.surnameIsValid(cognome)==0)
            user.setCognome(cognome);
        if(Check.mailIsValid(mail)==0)
            user.setMail(mail);
        if(Check.telephoneisValid(telefono)==0)
            user.setTelefono(telefono);
        if(Check.usernameIsValid(nomeUtente)==0)
            user.setNomeUtente(nomeUtente);
        if(Check.passwordIsValid(password,passwordCheck)==0)
            user.setPasswordHash(password);
        UtenteDAO dao=new UtenteDAO();
        dao.doUpdateUserInfo(user);
        dao.doUpdateUsername(user);
        dao.doUpdatePassword(user);
        session.removeAttribute("utenteSessione");
        session.setAttribute("utenteSessione",user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/Profilo.jsp");
        dispatcher.forward(request, response);

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

}
