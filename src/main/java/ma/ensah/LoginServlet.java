package ma.ensah;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username == null || password == null ||
            username.trim().isEmpty() || password.isEmpty()) {
            request.setAttribute("erreur", "Veuillez remplir tous les champs.");
            request.getRequestDispatcher("WEB-INF/views/login.jsp")
                   .forward(request, response);
            return;
        }

        if (UserStore.authenticate(username.trim(), password)) {
           
            HttpSession session = request.getSession();
            session.setAttribute("username", username.trim());
            session.setMaxInactiveInterval(30 * 60);  

            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("erreur", "Nom d'utilisateur ou mot de passe incorrect.");
            request.getRequestDispatcher("WEB-INF/views/login.jsp")
                   .forward(request, response);
        }
    }
}