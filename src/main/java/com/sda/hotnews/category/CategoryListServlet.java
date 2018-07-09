package com.sda.hotnews.category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

public class CategoryListServlet extends HttpServlet {


    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Set<Category> all = categoryDAO.getAll();

        req.setAttribute("categories",all);
        req.getRequestDispatcher("category/categories.jsp").forward(req,resp);


    }





}
