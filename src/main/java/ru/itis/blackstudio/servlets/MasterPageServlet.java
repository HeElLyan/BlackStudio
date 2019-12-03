package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.JspPaths;
import ru.itis.blackstudio.constants.Urls;
import ru.itis.blackstudio.models.Work;
import ru.itis.blackstudio.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(Urls.MASTER_PROFILE)
public class MasterPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] s = req.getRequestURI().split("/");
        int masterId = Integer.parseInt(s[s.length - 1]);

        ServiceFactory.masterService().findMasterById(masterId).ifPresent(value -> req.setAttribute("master", value));
        req.setAttribute("masterId", masterId);

        List<Work> works =  ServiceFactory.workService().findAll();
        req.setAttribute("works", works);
        req.getServletContext().getRequestDispatcher(JspPaths.MASTER_PROFILE).forward(req,resp);

    }
}
