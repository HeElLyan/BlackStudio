package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.MasterDaoJDBC;
import ru.itis.blackstudio.dao.models.MasterDao;
import ru.itis.blackstudio.models.Master;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/masters")
public class MastersServlet extends HttpServlet {
    private List<Master> masters;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/jsp/masters.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MasterDao masterDao = new MasterDaoJDBC(Singletons.getConnection());
        masterDao.findAll();
    }
}
