package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.*;
import ru.itis.blackstudio.exceptions.NonUniqueLoginException;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.ServiceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(Urls.REGISTER)
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("current_user") == null) {
            request.getServletContext().getRequestDispatcher(JspPaths.REGISTER).forward(request, response);

        } else {
            response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.MAIN);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(Parameters.LOGIN);
        String password = request.getParameter(Parameters.PASSWORD);
//        String repeatPassword = request.getParameter(Parameters.REPEAT_PASSWORD);
//
//        if (!password.equals(repeatPassword)) {
//            response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.REGISTER + "?" + PresenterKeys.REGISTER_KEY + "=" + PresenterKeys.PASSWORD_DIFF);
//            return;
//        }

        String name = request.getParameter(Parameters.NAME);
        String email = request.getParameter(Parameters.EMAIL);
        String phone = request.getParameter(Parameters.PHONE_NUMBER);
        String birth_date = request.getParameter(Parameters.BIRTHDATE);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode node = mapper.createObjectNode();
        node.put("name", name);
        node.put("phone", phone);
        node.put("email", email);
        node.put("birth_date", birth_date);

        try {
            User newUser = new User()
                    .setUsername(username)
                    .setPassword(password)
                    .setData(node.toString())
                    .setStatusId(2);
            ServiceFactory
                    .auth()
                    .signUp(newUser);
            request.getSession(true).setAttribute(Attributes.SESSION_USER_KEY, newUser);
            response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.MAIN);
        } catch (NonUniqueLoginException e) {
            response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.REGISTER + "?" + PresenterKeys.REGISTER_KEY + "=" + PresenterKeys.LOGIN_EXISTS);
        }
    }
}
