package ru.itis.blackstudio.dao.JDBC;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.models.MasterDao;

import ru.itis.blackstudio.models.Master;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MasterDaoJDBC implements MasterDao {
    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.master;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.master WHERE id_master = ?";

    //language=SQL
    private final String SQL_SELECT_BY_NAME =
            "SELECT * FROM black_studio.master WHERE name = ?";

    //language=SQL
    private final String SQL_SELECT_BY_WORKING_STYLE =
            "SELECT * FROM black_studio.master WHERE working_style = ?";

    //language=SQL
    private final String SQL_SELECT_BY_CITY =
            "SELECT * FROM black_studio.master WHERE city = ?";

    //language=SQL
    private final String SQL_INSERT = "INSERT INTO black_studio.master(id_master, name, phone, email, instagram, vk, experience, url_works, birth_date, city, working_style) VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

    private Connection connection;

    public MasterDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Master> rowMapper = resultSet -> {
        int id = resultSet.getInt("id_master");
        String name = resultSet.getString("name");
        String working_style = resultSet.getString("working_style");
        return new Master(id, name, working_style);
    };

    public Optional<Master> findByName(String name) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(rowMapper.rowMap(resultSet));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<Master> findByWorkingStyle(String working_style) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_WORKING_STYLE);
            statement.setString(1, working_style);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return Optional.of(rowMapper.rowMap(resultSet));

            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public Optional<Master> findByCity(String city) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_CITY);
            statement.setString(1, city);
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
    public Optional<Master> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Master model) {

    }

    @Override
    public void update(Master model) {

    }

    @Override
    public void delete(Master model) {

    }

    @Override
    public List<Master> findAll() {
        return null;
    }


}
