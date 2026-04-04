package ma.ensah;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");

        request.setAttribute("username", username);
        request.setAttribute("userCount", UserStore.getUserCount());

        request.getRequestDispatcher("WEB-INF/views/home.jsp")
               .forward(request, response);
    }
}