package com.example.firstjavaee;

import kz.javaee.db.DBManager;
import kz.javaee.db.Footballer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
        }catch (Exception e){

        }
        Footballer footballer = DBManager.getFootballer(id);

        if (footballer != null) {
            request.setAttribute("footballer", footballer);
            request.getRequestDispatcher("/details.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}