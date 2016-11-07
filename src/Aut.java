import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Autentification")
public class Aut extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login =request.getParameter("regLogin");
        String password =request.getParameter("regPass");
        if(DataBaseUse.authentificate(login,password)){
            request.setAttribute("message", "Well done vi auvtorizirovalis");

        }
        else{
            request.setAttribute("message", "LOHARA");
        }
        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}