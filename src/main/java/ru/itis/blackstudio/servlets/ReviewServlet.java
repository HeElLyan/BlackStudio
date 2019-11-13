package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.ReviewDaoJDBC;
import ru.itis.blackstudio.models.Review;
import ru.itis.blackstudio.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/review")
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewDaoJDBC reviewDaoJDBC = new ReviewDaoJDBC(Singletons.getConnection());

//        String s[] = req.getRequestURI().split("/");
//        int id_master = Integer.parseInt(s[s.length - 1]);

        List<Review> reviews = reviewDaoJDBC.findAll();

        req.setAttribute("reviews", reviews);

        //id_client from session
//        reviewDaoJDBC.insert(id_master, id_client, review);

//        List<Review> reviews = reviewDaoJDBC.findAll();
//        req.setAttribute("reviews", reviews);
//        reviewDaoJDBC.insert();
        req.getServletContext().getRequestDispatcher("/feedback_files/feedback.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("review");
        ReviewDaoJDBC daoJDBC = new ReviewDaoJDBC(Singletons.getConnection());
        daoJDBC.insert(
                ((User)req.getSession().getAttribute("current_user")).getId(),
                text
        );
        resp.sendRedirect(req.getContextPath() + "/main");

    }
}
