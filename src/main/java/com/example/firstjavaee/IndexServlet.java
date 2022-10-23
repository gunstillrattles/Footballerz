package com.example.firstjavaee;

import kz.javaee.db.DBManager;
import kz.javaee.db.Footballer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Footballer> footballers = DBManager.getFootballers();
        PrintWriter out = response.getWriter();
        out.println("<h1>FOOTBALLERS LIST</h1>");
        for(Footballer it : footballers){
            out.println("<h3>"+it.getId()+" "+it.getName()+" "+it.getSurname()+" "+it.getSalary()+" "+it.getClub()+" "+it.getTransferPrice()+"</h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}