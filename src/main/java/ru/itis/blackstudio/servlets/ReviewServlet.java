package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.constants.*;
import ru.itis.blackstudio.models.Master;
import ru.itis.blackstudio.models.Review;
import ru.itis.blackstudio.services.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(Urls.REVIEW)
public class ReviewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Review> reviews = ServiceFactory.reviewService().findAll();
        req.setAttribute(Attributes.LIST_OF_REVIEWS, reviews);

        req.getServletContext().getRequestDispatcher(JspPaths.REVIEW).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String masterName = request.getParameter("master_name");
        Optional<Master> master = ServiceFactory.masterService().findMasterByName(masterName);

        int masterId = master.get().getMasterId();
        int clientId = (int) request.getSession().getAttribute("current_user");
        String review = request.getParameter("review");
//        int rating = Integer.parseInt(request.getParameter("rating"));
//        String date = request.getParameter("date");

        if(true) {
            Review newReview = new Review()
                    .setMasterId(masterId)
                    .setClientId(clientId)
//                    .setRating(rating)
                    .setReview(review);
//                    .setDate(date);
            ServiceFactory.reviewService().save(newReview);
            request.getSession(true).setAttribute(Attributes.SESSION_USER_KEY, newReview);
            response.sendRedirect(request.getContextPath() + Urls.REVIEW);
        } else {
            response.sendRedirect(request.getContextPath() + Urls.LOGIN);
        }

//        ReviewDaoJDBC daoJDBC = new ReviewDaoJDBC(Singletons.getConnection());
//        daoJDBC.insert(
//                ((User)req.getSession().getAttribute("current_user")).getId(),
//                text
//        );
//        resp.sendRedirect(req.getContextPath() + "/main");

    }
}
