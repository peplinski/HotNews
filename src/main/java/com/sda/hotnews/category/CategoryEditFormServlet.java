package com.sda.hotnews.category;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CategoryEditFormServlet extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();

    /**
     * Prezentuje formularz edycji
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //pobieranie z parametru id z requestu
        String StrId = req.getParameter("id");
        //zamienianie na int
        int id = Integer.parseInt(StrId);
        //pobieranie z dao kategorii po id
        Optional<Category> optionalCategory = categoryDAO.getById(id);
        //zapisywanie w atrybucie requestu wyciagnietego obiektu z kategorii
        if (optionalCategory.isPresent()){
            Category category = optionalCategory.get();
            req.setAttribute("category",category);
            //przekierowanie na jsp z formularzem edycji
            req.getRequestDispatcher("category/category_edit_form.jsp").forward(req,resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String strId = req.getParameter("id");
       int id = Integer.parseInt(strId);
       String name = req.getParameter("name");

       //2wywolac metode edit
        int result = categoryDAO.edit(id,name);

        //jesli sie udalo, to przekierowac na strone z lista kategorii
        //
        if (result>0){
            //pokazuje komentarz
            req.setAttribute("_OK", "Edit: "+name+" Success!");
            //co bylo modyfikowane
            req.setAttribute("lastModified", id);
            //przekierowujemy
            req.setAttribute("categories", categoryDAO.getAll());
            req.getRequestDispatcher("category/categories.jsp").forward(req,resp);

        }
        req.getRequestDispatcher("category/categories.jsp").forward(req,resp);
        return;
    }


}
