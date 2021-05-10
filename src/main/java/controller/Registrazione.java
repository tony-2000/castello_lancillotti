package controller;

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
        String mail = request.getParameter("mail");
        String nome = request.getParameter("nome");
        String cognome = request.getParameter("cognome");
        String telefono = request.getParameter("telefono");
        Utente utente = new Utente();
        utente.setNomeUtente(username);
        utente.setPasswordHash(password);
        utente.setMail(mail);
        utente.setNome(nome);
        utente.setCognome(cognome);;
        utente.setTelefono(telefono);
        UtenteDAO saving = new UtenteDAO();
        saving.doSave(utente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/Login.jsp");
        dispatcher.forward(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    { }

}