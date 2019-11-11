package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.JDBC.ReviewDaoJDBC;
import ru.itis.blackstudio.models.Review;

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
        req.getServletContext().getRequestDispatcher("/feedback_files/feedback.jsp").forward(req,resp);
        ReviewDaoJDBC reviewDaoJDBC = new ReviewDaoJDBC(Singletons.getConnection());
        List<Review> reviews = reviewDaoJDBC.findAll();

        req.setAttribute("review", reviews);
    }
}
