package com.sda.hotnews.category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CategoryAddServlet extends HttpServlet {

    private CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (null==name || name.isEmpty()){
            req.setAttribute("_ERROR","Nie podano nazwy Kategorii!");
            req.getRequestDispatcher("category/category_add_form.jsp").forward(req, resp);
            return;
        }

        int result = categoryDAO.add(name);

        if (result>0){
            req.setAttribute("lastModified", result);
            req.setAttribute("_OK","Dodano kategorię "+name);
            req.setAttribute("categories", categoryDAO.getAll());
            req.getRequestDispatcher("category/categories.jsp").forward(req,resp);
            return;
        }

        req.getRequestDispatcher("category/category_add_form.jsp").forward(req, resp);

    }
}
