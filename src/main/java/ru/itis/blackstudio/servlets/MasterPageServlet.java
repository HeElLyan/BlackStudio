package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.MasterDaoJDBC;
import ru.itis.blackstudio.dao.JDBC.WorksDaoJDBC;
import ru.itis.blackstudio.dao.models.MasterDao;
import ru.itis.blackstudio.dao.models.WorksDao;
import ru.itis.blackstudio.models.Master;
import ru.itis.blackstudio.models.Work;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/masters/masterPage/*")
public class MasterPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s[] = req.getRequestURI().split("/");
        int id_master = Integer.parseInt(s[s.length - 1]);

        MasterDao masterDao = new MasterDaoJDBC(Singletons.getConnection());
        Optional<Master> master = masterDao.findById(id_master);
        master.ifPresent(value -> req.setAttribute("master", value));
        req.setAttribute("id_master",id_master);
        WorksDao worksDao = new WorksDaoJDBC(Singletons.getConnection());
        List<Work> works = worksDao.findAllById(id_master);
        req.setAttribute("works", works);
        req.getServletContext().getRequestDispatcher("/masterMargo/masterMargo.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
