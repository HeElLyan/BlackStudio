package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.UsersDaoJDBC;
import ru.itis.blackstudio.dao.models.UserDao;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.Auth;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Optional;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("isLogIn").equals(0)) {
            request.getServletContext().getRequestDispatcher("/login_files/login.jsp").forward(request, response);
        } else {
            response.sendRedirect("/main_str/main_str.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Auth auth = new Auth();
        Optional<User> user = auth.signIn(username, password);

        request.getSession().setAttribute("current_user", user.get());
        request.getSession().setAttribute("isLogin", new Integer(1));
        response.sendRedirect("/profile/" +
                ((User)request.getSession().getAttribute("current_user")).getUsername());
//                UserDao dao = new UsersDaoJDBC(Singletons.getConnection());
//
//        Optional<User> usr = dao.findByUsername("el");
//        request.setAttribute("user", usr.get().getPassword());
        if(user.isPresent()){
            request.getServletContext().getRequestDispatcher("/main_str/main_str.jsp").forward(request, response);
        } else {
            doGet(request, response);
        }
    }
}
