package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.UsersDaoJDBC;
import ru.itis.blackstudio.dao.models.UserDao;
import ru.itis.blackstudio.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/profile/*")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String[] s = request.getRequestURI().split("/");
            String username = s[s.length - 1];
//            if (username != null && !username.isEmpty()) {
//                UserDao dao = new UsersDaoJDBC(Singletons.getConnection());
//                dao.findByUsername(username);
            User user = (User) request.getSession().getAttribute("current_user");
            request.setAttribute("user", user);
            request.getServletContext().getRequestDispatcher("/profile/profile.jsp").forward(request, response);


    }
}
