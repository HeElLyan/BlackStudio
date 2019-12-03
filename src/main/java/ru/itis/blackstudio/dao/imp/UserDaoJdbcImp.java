package ru.itis.blackstudio.dao.imp;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.UserDao;

import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.utils.SingletonConnection;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoJdbcImp extends AbstractDaoJdbcImp implements UserDao {

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.client;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.client WHERE id_client = ?";

    //language=SQL
    private final String SQL_SELECT_BY_USERNAME =
            "SELECT * FROM black_studio.client WHERE username = ?";

    //language=SQL
    private final String SQL_INSERT_USER ="INSERT INTO black_studio.client(username, name, password, email, phone) VALUES (?,?,?,?,?)";

    //language=SQL
    private final String SQL_UPDATE_USER ="UPDATE black_studio.client SET username = ?, password = ?, name = ?, email = ?, phone = ?";

    //language=MySQL
    public static final String SQL_DELETE_USER = "" +
            "DELETE FROM black_studio.client WHERE id_client = ?";

    public UserDaoJdbcImp(SingletonConnection singletonConnection) {
        super(singletonConnection);
    }

    private RowMapper<User> rowMapper = resultSet -> new User()
            .setUsername(resultSet.getString("username"))
            .setPhone(resultSet.getString("phone"))
            .setName(resultSet.getString("name"))
//            .setId(resultSet.getInt("id"))
            .setPassword(resultSet.getString("password"))
            .setEmail(resultSet.getString("email"));
//            .setStatusId(resultSet.getInt("status_id"));

    @Override
    public boolean isUnique(String login) {
        try {
            return !queryOfFirst(rowMapper, SQL_SELECT_BY_USERNAME, login).isPresent();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<User> findAll() {
//        try {
//            List<User> users = new ArrayList<>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
//            while (resultSet.next()) {
//                Integer id = resultSet.getInt("clientId");
//                String username = resultSet.getString("username");
//                String password = resultSet.getString("password");
//
//                User user = new User(id, username, password);
//
//                users.add(user);
//            }
//            return users;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
        try {
            return queryOfMany(rowMapper, SQL_SELECT_ALL);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
//            statement.setInt(1, id);
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
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, id);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_USERNAME);
//            statement.setString(1, username);
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
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_USERNAME, username);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean save(User user) {
        try {
            Optional<Integer> id = queryOfSecond(x -> x.getInt("LAST_INSERT_ID()"),
                    SQL_INSERT_USER, user.getUsername(), user.getPassword(), user.getData(), user.getStatusId());
            id.ifPresent(user::setId);
            return id.isPresent();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> find(Integer id) {
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, id);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(User model) {
        try {
            return update(SQL_UPDATE_USER, model.getId(),
                    model.getUsername(), model.getPassword(), model.getData(), model.getStatusId())
                    > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            return update(SQL_DELETE_USER, id) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
