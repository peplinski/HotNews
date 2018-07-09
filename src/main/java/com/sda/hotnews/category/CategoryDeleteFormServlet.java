package com.sda.hotnews.category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryDeleteFormServlet extends HttpServlet {

    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strId = req.getParameter("id");
        int id = Integer.parseInt(strId);
        String name = req.getParameter("name");

        int delete = categoryDAO.remove(id);

        if (delete>0){
            //pokazuje komentarz
            req.setAttribute("_OK", "Delete: "+name+" Success!");
            //co bylo modyfikowane
            req.setAttribute("lastModified", id);
            //przekierowujemy
            req.setAttribute("categories", categoryDAO.getAll());
            req.getRequestDispatcher("category/categories.jsp").forward(req,resp);
            return;

        }
        req.getRequestDispatcher("category/categories.jsp").forward(req,resp);
        return;
    }
}
