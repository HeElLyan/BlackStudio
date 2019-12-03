package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.JspPaths;
import ru.itis.blackstudio.constants.Urls;
import ru.itis.blackstudio.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Urls.USER_PROFILES)
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//            String[] s = request.getRequestURI().split("/");
//            String username = s[s.length - 1];
//
//            request.setAttribute("user", request.getSession().getAttribute("current_user"));
            request.getServletContext().getRequestDispatcher(JspPaths.USER_PROFILE).forward(request, response);

    }
}
