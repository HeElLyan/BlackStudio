package ru.itis.blackstudio.dao.JDBC;

import ru.itis.blackstudio.constants.Singletons;
import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.models.CookieDao;
import ru.itis.blackstudio.dao.models.UserDao;
import ru.itis.blackstudio.models.Cookie;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.models.UserPass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CookieDaoJDBC implements CookieDao {

    private Connection connection;

    public CookieDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    //language=SQL
    private final String SQL_SELECT_BY_HASH = "SELECT id_client FROM black_studio.cookie WHERE hash = ?;";

    //language=SQL
    private final String SQL_INSERT_HASH = "INSERT INTO black_studio.cookie(id_client, hash) VALUES (?,?) ";

    //language=SQL
    private final String SQL_DELETE_HASH = "DELETE FROM black_studio.cookie WHERE id_client = ? ";

    private RowMapper<Cookie> rowMapper = resultSet -> {
        int id_client = resultSet.getInt("id_client");
        String hash = resultSet.getString("hash");
        return new Cookie(id_client, hash);
    };

    @Override
    public Optional<Cookie> compareValue(String hashCookie) {
        try{
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_HASH);
            statement.setString(1, hashCookie);
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
    public String add(UserPass usps) {
        UserDao person = new UsersDaoJDBC(Singletons.getConnection());
        Optional<User> user = person.findByUsername(usps.getUsername());
        try {
            PreparedStatement st = connection.prepareStatement(SQL_INSERT_HASH);
            st.setInt(1,user.get().getId());
            st.setString(2,usps.hashCookie());
            st.executeUpdate();
            return usps.hashCookie();
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean delete(int id_client) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_HASH);
            preparedStatement.setInt(1, id_client);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Optional find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void delete(Object model) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
