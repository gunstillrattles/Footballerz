package kz.javaee.db;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/add")
public class AddFootballerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addfootballer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id= Long.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int salary = Integer.parseInt(request.getParameter("salary"));
        String club = request.getParameter("club");
        int transfer_price = Integer.parseInt(request.getParameter("transfer_price"));
        Footballer it = new Footballer(id, name, surname, salary, club, transfer_price);
        DBManager.addFootballer(it);
        response.sendRedirect("/add?success");
    }
}