package ru.itis.blackstudio.dao.imp;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.MasterDao;

import ru.itis.blackstudio.models.Master;
import ru.itis.blackstudio.utils.SingletonConnection;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class MasterDaoJdbcImp extends AbstractDaoJdbcImp implements MasterDao {

    public MasterDaoJdbcImp(SingletonConnection singletonConnection) {
        super(singletonConnection);
    }

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.master;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.master WHERE id_master = ?";

    //language=SQL
    private final String SQL_SELECT_BY_NAME =
            "SELECT * FROM black_studio.master WHERE name = ?";

    //language=SQL
    private final String SQL_SELECT_BY_WORKINGSTYLE =
            "SELECT * FROM black_studio.master WHERE working_style = ?";

    //language=SQL
    private final String SQL_INSERT_MASTER = "INSERT INTO black_studio.master(name, phone, email, instagram, vk, experience, working_style, birth_date, city) VALUES (?,?,?,?,?,?,?,?,?) ";

    //language=SQL
    private final String SQL_UPDATE_MASTER ="UPDATE black_studio.master SET name = ?, email = ?, phone = ?, experience = ?, working_style = ?, phone = ?";

    //language=MySQL
    public static final String SQL_DELETE_MASTER = "DELETE FROM black_studio.master WHERE id_master = ?";

    private RowMapper<Master> rowMapper = resultSet -> new Master()
            .setMasterId(resultSet.getInt("id_master"))
            .setName(resultSet.getString("name"))
            .setExperience(resultSet.getInt("experience"))
            .setPhone(resultSet.getLong("phone"))
            .setWorkingStyle(resultSet.getString("working_style"))
            .setUrlPhoto(resultSet.getString("photo_url"));

    @Override
    public Optional<Master> findByName(String name) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_NAME);
//            statement.setString(1, name);
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
            return queryOfFirst(rowMapper, SQL_SELECT_BY_NAME, name);
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }
//
//    @Override
//    public Optional<Master> findById(int masterId) {
////        try {
////            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
////            statement.setInt(1, masterId);
////            ResultSet resultSet = statement.executeQuery();
////
////            if (resultSet.next()) {
////                return Optional.of(rowMapper.rowMap(resultSet));
////
////            }
////            return Optional.empty();
////        } catch (SQLException e) {
////            throw new IllegalStateException(e);
////        }
//        try {
//            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, masterId);
//        } catch (SQLException e) {
//            throw new IllegalStateException();
//        }
//    }

    @Override
    public Optional<Master> findByWorkingStyle(String workingStyle) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_workingStyle);
//            statement.setString(1, workingStyle);
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
            return queryOfFirst(rowMapper, SQL_SELECT_BY_WORKINGSTYLE, workingStyle);
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public List<Master> findAll() {
//        try {
//            List<Master> masters = new ArrayList<>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
//            while (resultSet.next()) {
//                int masterId = resultSet.getInt("masterId");
//                String name = resultSet.getString("name");
//                String urlPhoto = resultSet.getString("urlPhoto");
//                String workingStyle = resultSet.getString("workingStyle");
//
//                Master master = new Master(masterId, name, urlPhoto, workingStyle);
//
//                masters.add(master);
//
//            }
//            return masters;
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
    public boolean save(Master master) {
        try {
            Optional<Integer> id = queryOfSecond(x -> x.getInt("LAST_INSERT_ID()"),
                    SQL_INSERT_MASTER, master.getName(), master.getWorkingStyle(), master.getWorks(), master.getExperience());
            id.ifPresent(master::setMasterId);
            return id.isPresent();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<Master> find(Integer id) {
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, id);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Master master) {
        try {
            return update(SQL_UPDATE_MASTER, master.getMasterId(),
                    master.getName(), master.getWorkingStyle(), master.getWorks(), master.getExperience())
                    > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            return update(SQL_DELETE_MASTER, id) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
