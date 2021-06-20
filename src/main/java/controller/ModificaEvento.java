package controller;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
@WebServlet(name="ModificaEvento", value="/ModificaEvento")
@MultipartConfig
public class ModificaEvento extends HttpServlet
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Evento evento=new Evento();
        EventoDAO dao=new EventoDAO();
        evento.setIdEvento(Integer.parseInt(request.getParameter("idEvento")));
        evento.setIdCategoria(Integer.parseInt(request.getParameter("cate")));
        evento.setNome(request.getParameter("nome"));
        evento.setDescrizione(request.getParameter("descrizione"));
        evento.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));


        if(!request.getPart("image").getContentType().equals("application/octet-stream")) {
            Part image = request.getPart("image");
            String nameImage = Paths.get(image.getSubmittedFileName()).getFileName().toString();
            String uploadPath = System.getenv("CATALINA_HOME") + File.separator + "uploads" + File.separator;
            InputStream stream = image.getInputStream();
            String linkImmagine = uploadPath + nameImage;
            File file = new File(linkImmagine);
            try {
                Files.copy(stream, file.toPath());
            } catch (FileAlreadyExistsException e) {
                /* do nothing */
            }
            evento.setLinkImmagine("/Castello_Lancillotti_war_exploded/covers/"+nameImage);
        }
        else
        {
            evento.setLinkImmagine(request.getParameter("link"));
        }


        dao.doUpdate(evento);
        ArrayList<Evento> eventi=new ArrayList<>();
        eventi= (ArrayList<Evento>) dao.doRetrieveAllEvents();
        request.setAttribute("eventi",eventi);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviEvento.jsp");
        dispatcher.forward(request, response);
    }
}
