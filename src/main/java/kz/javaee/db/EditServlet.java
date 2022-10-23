package kz.javaee.db;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id=Long.parseLong(request.getParameter("id"));
        Footballer football=DBManager.getFootballer(id);
        if(football!=null){
            request.setAttribute("football",football);
            request.getRequestDispatcher("/edit.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/404.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id= Long.valueOf(request.getParameter("id"));
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        int salary=Integer.parseInt(request.getParameter("salary"));
        String club=request.getParameter("club");
        int transferPrice=Integer.parseInt(request.getParameter("transferprice"));

        Footballer football=DBManager.getFootballer(id);
        if(football!=null){
            football.setId(id);
            football.setName(name);
            football.setSurname(surname);
            football.setSalary(salary);
            football.setClub(club);
            football.setTransferPrice(transferPrice);

            if(DBManager.savePlayer(football)){
                response.sendRedirect("/edit?id="+id+"&success");
            }else {
                response.sendRedirect("/edit?id="+id+"&error");
            }

        }else{
            response.sendRedirect("/");
        }
    }
}
