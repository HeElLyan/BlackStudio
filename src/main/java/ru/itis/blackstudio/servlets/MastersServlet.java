package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Attributes;
import ru.itis.blackstudio.constants.JspPaths;
import ru.itis.blackstudio.constants.Urls;
import ru.itis.blackstudio.services.ServiceFactory;
import ru.itis.blackstudio.models.Master;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(Urls.MASTERS)
public class MastersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Master> masters = ServiceFactory.masterService().findAll();
//        MasterDao masterDao = new MasterDaoJdbcImpl(Singletons.getConnection());
//        List<Master> masters = masterDao.findAll();

        request.setAttribute(Attributes.LIST_OF_MASTERS, masters);

        request.getServletContext().getRequestDispatcher(JspPaths.MASTERS).forward(request,response);
    }
}
