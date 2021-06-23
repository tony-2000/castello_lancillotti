package controller;

import model.Categoria;
import model.CategoriaDAO;
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

/*Aggiunge una categoria tramite le informazioni inserite*/

@WebServlet(name="doAggiungiCategoria", value="/doAggiungiCategoria")
@MultipartConfig
public class doAggiungiCategoria extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Part image = request.getPart("image");
        String nameImage = Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String uploadPath = "C:"+ File.separator+"Program Files (x86)" +File.separator + "Apache Software Foundation" + File.separator + "Tomcat 9.0" + File.separator + "uploads" + File.separator;
        InputStream stream = image.getInputStream();
        String linkImmagine = uploadPath + nameImage;
        File file = new File(linkImmagine);
        try {
            Files.copy(stream, file.toPath());
        } catch (FileAlreadyExistsException e) {
            /* do nothing */
        }

        Categoria cat= new Categoria();
        CategoriaDAO dao=new CategoriaDAO();
        cat.setNome(request.getParameter("nome"));
        cat.setLinkImmagine("/Castello_Lancillotti_war_exploded/covers/"+nameImage);
        dao.doSave(cat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AreaAdmin.jsp");
        dispatcher.forward(request, response);
    }
}