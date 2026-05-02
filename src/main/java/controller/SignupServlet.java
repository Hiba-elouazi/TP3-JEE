package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import model.UserDAO;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/signup.jsp")
               .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String confirm  = request.getParameter("confirm");

        if (username == null || username.trim().isEmpty() ||
            password == null || password.isEmpty()) {
            request.setAttribute("erreur", "Tous les champs sont obligatoires.");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp")
                   .forward(request, response);
            return;
        }

        if (!password.equals(confirm)) {
            request.setAttribute("erreur", "Les mots de passe ne correspondent pas.");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp")
                   .forward(request, response);
            return;
        }

        if (UserDAO.userExists(username.trim())) {
            request.setAttribute("erreur", "Ce nom d'utilisateur est déjà pris.");
            request.getRequestDispatcher("/WEB-INF/views/signup.jsp")
                   .forward(request, response);
            return;
        }

        UserDAO.register(username.trim(), password);
        request.setAttribute("succes", "Compte créé ! Vous pouvez maintenant vous connecter.");
        request.getRequestDispatcher("/WEB-INF/views/login.jsp")
               .forward(request, response);
    }
}