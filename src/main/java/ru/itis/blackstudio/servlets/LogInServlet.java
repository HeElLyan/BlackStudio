package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.*;
import ru.itis.blackstudio.exceptions.IncorrectLoginOrPasswordException;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.ServiceFactory;
import ru.itis.blackstudio.utils.CookiesUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(Urls.LOGIN)
public class LogInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        if (request.getSession().getAttribute("current_user") == null) {
////            request.getServletContext().getRequestDispatcher(JspPaths.LOGIN).forward(request, response);
////        } else {
////            response.sendRedirect(request.getContextPath() + Urls.MAIN);
////        }
        request.getServletContext().getRequestDispatcher(JspPaths.LOGIN).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);

//        Optional<User> user = ServiceFactory.auth().signIn(username, password);
//
//        if(user.isPresent()){
//            request.getSession(true).setAttribute(Attributes.SESSION_USER_KEY, user.get());
//            response.sendRedirect(request.getContextPath() + Urls.USER_PROFILE + "/" +
//                    ((User)request.getSession().getAttribute(Attributes.SESSION_USER_KEY)).getUsername()
//            );
//        }

        boolean doRemember = Optional.ofNullable(request.getParameter(Parameters.REMEMBER)).isPresent();

        try {
            User user = ServiceFactory.auth().signIn(username, password);
            request.getSession(true).setAttribute(Attributes.SESSION_USER_KEY, user);

            if (doRemember)
                CookiesUtil.addUserId(user.getId(), response);
            response.sendRedirect(request.getContextPath() + Urls.USER_PROFILE + "/" +
                    ((User) request.getSession().getAttribute(Attributes.SESSION_USER_KEY)).getUsername());
        } catch (IncorrectLoginOrPasswordException e) {
            response.sendRedirect(request.getContextPath() + Urls.MAIN);
        }

//        // SOOOOOOS
//        UserPass usps = new UserPass(username,password);
//        boolean rememberMe = request.getParameter("remember") != null;
//        if (rememberMe) {
//            CookieService cookieService = new CookieService();
//            cookieService.cookie(usps);
//        }
    }
}
