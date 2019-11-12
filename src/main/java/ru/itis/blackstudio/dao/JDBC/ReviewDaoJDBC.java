package ru.itis.blackstudio.dao.JDBC;

import ru.itis.blackstudio.dao.CrudDao;
import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.models.ReviewDao;
import ru.itis.blackstudio.models.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReviewDaoJDBC implements ReviewDao {
    private Connection connection;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.review;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.review WHERE id_master = ?";

    //language=SQL
    private final String SQL_INSERT = "INSERT INTO black_studio.review(id_master, id_client, review) VALUES (?,?,?) ";

    public ReviewDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Review> rowMapper = resultSet -> {
        int id_client = resultSet.getInt("id_client");
        int id_master = resultSet.getInt("id_master");
        String review = resultSet.getString("review");
        return new Review(id_client, id_master, review);
    };

    public Optional<Review> findByMasterId(String id_master) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setString(1, id_master);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(rowMapper.rowMap(resultSet));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<Review> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Review model) {

    }

    @Override
    public void update(Review model) {

    }

    @Override
    public void delete(Review model) {

    }

    @Override
    public List<Review> findAll() {
        return null;
    }

    public List<Review> findAllById(int id_master) {
        try {
            List<Review> reviews = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                int id_client = resultSet.getInt("id_client");
                String review_1 = resultSet.getString("review");

                Review review = new Review(id_client, id_master, review_1);

                reviews.add(review);
            }
            return reviews;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void insert(int id_master, int id_client, String review) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1, id_client);
            preparedStatement.setInt(2, id_master);
            preparedStatement.setString(3, review);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
