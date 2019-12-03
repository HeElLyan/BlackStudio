package ru.itis.blackstudio.dao.imp;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.ReviewDao;
import ru.itis.blackstudio.models.Review;
import ru.itis.blackstudio.utils.SingletonConnection;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ReviewDaoJdbcImp extends AbstractDaoJdbcImp implements ReviewDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.review;";

    //language=SQL
    private final String SQL_SELECT_BY_ID = "SELECT * FROM black_studio.review WHERE id_client = ?;";

    //language=SQL
    private final String SQL_INSERT_REVIEW = "INSERT INTO black_studio.review(review, date, rating) VALUES (?,?,?) ";

    //language=SQL
    private final String SQL_UPDATE_REVIEW ="UPDATE black_studio.review SET review = ?, rating = ?, date = ?";

    //language=MySQL
    public static final String SQL_DELETE_REVIEW = "" +
            "DELETE FROM black_studio.review WHERE id_client = ?";


    public ReviewDaoJdbcImp(SingletonConnection singletonConnection) {
        super(singletonConnection);
    }

    private RowMapper<Review> rowMapper = resultSet -> new Review()
            .setReview(resultSet.getString("review"))
            .setMasterId(resultSet.getInt("id_master"))
            .setClientId(resultSet.getInt("id_client"))
            .setRating(resultSet.getInt("rating"))
            .setDate(resultSet.getString("date"));


    @Override
    public List<Review> findAll() {
        try {
            return queryOfMany(rowMapper, SQL_SELECT_ALL);
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public boolean save(Review review) {
        try {
            Optional<Integer> id = queryOfSecond(x -> x.getInt("LAST_INSERT_ID()"),
                    SQL_INSERT_REVIEW, review.getClientId(), review.getMasterId(), review.getDate(), review.getReview(), review.getRating());
            id.ifPresent(review::setId);
            return id.isPresent();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<Review> find(Integer id) {
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, id);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Review model) {
        try {
            return update(SQL_UPDATE_REVIEW, model.getId(),
                    model.getClientId(), model.getMasterId(), model.getDate(), model.getReview(), model.getRating()) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            return update(SQL_DELETE_REVIEW, id) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


//    public Optional<Review> findByMaster(String masterId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
//            statement.setString(1, masterId);
//            ResultSet resultSet = statement.executeQuery();
//
//            if (resultSet.next()) {
//                return Optional.of(rowMapper.rowMap(resultSet));
//
//            }
//            return Optional.empty();
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }


//    public List<Review> findAllById(int masterId) {
//        try {
//            List<Review> reviews = new ArrayList<>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
//            while (resultSet.next()) {
//                int clientId = resultSet.getInt("clientId");
//                String review_1 = resultSet.getString("review");
//
//                Review review = new Review(clientId, masterId, review_1);
//
//                reviews.add(review);
//            }
//            return reviews;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//        try {
//            return queryOfFirst()
//        }
//    }

}
