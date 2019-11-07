package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.dao.models.UsersDao;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/logIn")
public class LogInServlet extends HttpServlet {
    private UsersDao usersDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/jsp/logIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Auth auth = new Auth();
        Optional<User> user = auth.signIn(username, password);
        if(user.isPresent()){
            request.getServletContext().getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        } else {
            doGet(request, response);
        }

    }
}
