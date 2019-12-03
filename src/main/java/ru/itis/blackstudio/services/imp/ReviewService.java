package ru.itis.blackstudio.services.imp;

import ru.itis.blackstudio.client.DaoPool;
import ru.itis.blackstudio.dao.ReviewDao;
import ru.itis.blackstudio.models.Review;

import java.util.List;
import java.util.Optional;

public class ReviewService {
    public Optional<Review> findReviewById (int masterId){
        ReviewDao reviewDao = DaoPool.getReviewDao();
        return reviewDao.find(masterId);
    }

    public boolean save(Review review) {
        ReviewDao reviewDao = DaoPool.getReviewDao();
        return reviewDao.save(review);
    }

    public List<Review> findAll() {
        ReviewDao reviewDao = DaoPool.getReviewDao();
        return reviewDao.findAll();
    }
}
