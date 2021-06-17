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
import java.io.IOException;

@WebServlet(name="Registrazione", urlPatterns = {"/Registrazione"})
public class Registrazione extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String username = request.getParameter("nome_utente");
        String password = request.getParameter("password");
        String passwordCheck = request.getParameter("passwordCheck");
        String mail = request.getParameter("mail");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono = request.getParameter("telefono");
        String url="Login.jsp";

        int checkUsername=Check.usernameIsValid(username);
        int checkPass=Check.passwordIsValid(password,passwordCheck);
        int checkMail=Check.mailIsValid(mail);
        int checkNome=Check.nameIsValid(nome);
        int checkCognome=Check.surnameIsValid(cognome);
        int checkTelefono=Check.telephoneisValid(telefono);

        if(checkUsername+checkPass+checkMail+checkCognome+checkNome+checkTelefono==0)
        {
            Utente utente = new Utente();
            utente.setNomeUtente(username);
            utente.setPasswordHash(password);
            utente.setMail(mail);
            utente.setNome(nome);
            utente.setCognome(cognome);
            utente.setTelefono(telefono);
            UtenteDAO saving = new UtenteDAO();
            saving.doSave(utente);
        }
        else
        {
            int check=0;
            if(checkUsername==-4)
                check=-1;
            if(checkMail==-6)
                check=-2;
            url="Registrazione.jsp";
            request.setAttribute("datiPresenti",check);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { }

}