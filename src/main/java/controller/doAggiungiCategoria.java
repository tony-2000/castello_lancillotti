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
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name="doAggiungiCategoria", value="/doAggiungiCategoria")
@MultipartConfig
public class doAggiungiCategoria extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doPost(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Part image=request.getPart("image");
        String nameImage= Paths.get(image.getSubmittedFileName()).getFileName().toString();
        String uploadPath=System.getenv("CATALINA_HOME")+ File.separator+"uploads"+File.separator;
        InputStream stream=image.getInputStream();
        String linkImmagine=uploadPath+nameImage;
        File file=new File(linkImmagine);
        Files.copy(stream,file.toPath());


        Categoria cat= new Categoria();
        CategoriaDAO dao=new CategoriaDAO();
        cat.setNome(request.getParameter("nome"));
        cat.setLinkImmagine(linkImmagine);
        dao.doSave(cat);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/AreaAdmin.jsp");
        dispatcher.forward(request, response);
    }
}