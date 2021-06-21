package controller;

import model.Evento;
import model.EventoDAO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

/*Aggiunge un evento tramite le informazioni inserite*/

@WebServlet(name="doAggiungiEvento", value="/doAggiungiEvento")
@MultipartConfig
    public class doAggiungiEvento extends HttpServlet {
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
        {
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

            Evento event= new Evento();
            EventoDAO dao=new EventoDAO();
            event.setIdCategoria(Integer.parseInt(request.getParameter("categorie")));
            event.setNome(request.getParameter("nome"));
            event.setDescrizione(request.getParameter("descrizione"));
            event.setPrezzo(Float.parseFloat(request.getParameter("prezzo")));
            event.setLinkImmagine("/Castello_Lancillotti_war_exploded/covers/"+nameImage);

            dao.doSave(event);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AreaAdmin.jsp");
            dispatcher.forward(request, response);
        }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {}

    }



