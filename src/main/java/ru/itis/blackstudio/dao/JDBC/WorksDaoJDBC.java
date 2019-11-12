package ru.itis.blackstudio.dao.JDBC;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.models.WorksDao;
import ru.itis.blackstudio.models.Master;
import ru.itis.blackstudio.models.Work;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorksDaoJDBC implements WorksDao {
    private Connection connection;

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.master_works;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.master_works WHERE id_master = ?";

    public WorksDaoJDBC(Connection connection) {
        this.connection = connection;
    }

    private RowMapper<Work> rowMapper = resultSet -> {
        int id_master = resultSet.getInt("id_master");
        String url_photo = resultSet.getString("url_photo");
        return new Work(id_master, url_photo);
    };

    @Override
    public Optional<Work> findByName(String name) {
        return Optional.empty();
    }

    public Optional<Work> findById(int id_master) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id_master);
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
    public Optional<Work> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(Work model) {

    }

    @Override
    public void update(Work model) {

    }

    @Override
    public void delete(Work model) {

    }

    @Override
    public List<Work> findAll() {
        try {
            List<Work> works = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                int id_master = resultSet.getInt("id_master");
                String url_work = resultSet.getString("url_work");
                Work work = new Work(id_master, url_work);

                works.add(work);
            }
            return works;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public List<Work> findAllById(int id_master) {
        try {
            List<Work> works = new ArrayList<>();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
            while (resultSet.next()) {
                String url_work = resultSet.getString("url_work");
                Work work = new Work(id_master, url_work);

                works.add(work);
            }
            return works;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
