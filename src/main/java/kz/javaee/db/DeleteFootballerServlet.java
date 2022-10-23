package kz.javaee.db;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteFootballerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));
        Footballer football=DBManager.getFootballer(id);
        if(football!=null){
            if(DBManager.deleteFootballer(football)){
                response.sendRedirect("/");
            }else {
                response.sendRedirect("/edit?id="+id+"&error");
            }
        }else {
            response.sendRedirect("/");
        }

    }
}
