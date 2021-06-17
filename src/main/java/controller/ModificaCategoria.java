package controller;

import model.*;

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
import java.util.ArrayList;
@WebServlet(name="ModificaCategoria", value="/ModificaCategoria")
@MultipartConfig
public class ModificaCategoria extends HttpServlet
{
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

        Categoria categoria=new Categoria();
        CategoriaDAO dao=new CategoriaDAO();
        categoria.setIdCategoria(Integer.parseInt(request.getParameter("idCategoria")));
        categoria.setNome(request.getParameter("nome"));
        categoria.setLinkImmagine("/Castello_Lancillotti_war_exploded/covers/"+nameImage);
        dao.doUpdate(categoria);
        ArrayList<Categoria> categorie= (ArrayList<Categoria>) dao.doRetrieveAllCategories();
        categorie.removeIf(x->x.getIdCategoria()==1);
        request.setAttribute("categoria",categorie);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/results/ModificaRimuoviCategoria.jsp");
        dispatcher.forward(request, response);
    }
}
