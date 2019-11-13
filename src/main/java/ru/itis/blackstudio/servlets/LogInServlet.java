package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.CookieDaoJDBC;
import ru.itis.blackstudio.dao.models.CookieDao;
import ru.itis.blackstudio.dao.models.UserDao;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.models.UserPass;
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
        if (request.getSession().getAttribute("current_user") == null) {
            request.getServletContext().getRequestDispatcher("/login_files/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/main");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Auth auth = new Auth();
        Optional<User> user = auth.signIn(username, password);

        if(user.isPresent()){
            HttpSession session = request.getSession();
            request.getSession().setAttribute("current_user", user.get());
            response.sendRedirect(request.getContextPath() + "/profile/" +
                ((User)request.getSession().getAttribute("current_user")).getUsername()
            );
        }

        UserPass usps = new UserPass(username,password);
        boolean rememberMe = request.getParameter("remember") != null;
        if (rememberMe) {
            CookieDao cookieDao = new CookieDaoJDBC(Singletons.getConnection());
            Cookie cookie = new Cookie("remember",
                    URLEncoder.encode(cookieDao.add(usps), "UTF-8"));
            cookie.setMaxAge(60*60*24*365);
            cookie.setSecure(false);
            response.addCookie(cookie);
//            System.out.println("Cookie is added!!!");
        }
//        Optional<User> usr = dao.findByUsername("el");
//        request.setAttribute("user", usr.get().getPassword());
    }
}
