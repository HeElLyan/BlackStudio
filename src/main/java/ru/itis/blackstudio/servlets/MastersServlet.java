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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MasterDao masterDao = new MasterDaoJDBC(Singletons.getConnection());
        List<Master> masters = masterDao.findAll();

        request.setAttribute("masters", masters);
        request.getServletContext().getRequestDispatcher("/masters/masters.jsp").forward(request,response);

//        String[] s = request.getRequestURI().split("/");
//        int artist_id = Integer.parseInt(s[s.length - 1]);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
