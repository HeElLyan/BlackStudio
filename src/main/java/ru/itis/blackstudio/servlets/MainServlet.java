package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.JspPaths;
import ru.itis.blackstudio.constants.Urls;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Urls.MAIN)
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.getServletContext().getRequestDispatcher(JspPaths.MAIN).forward(request,response);
    }
}
