package ru.itis.blackstudio.dao.imp;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.dao.WorkDao;
import ru.itis.blackstudio.models.Work;
import ru.itis.blackstudio.utils.SingletonConnection;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class WorkDaoJdbcImp extends AbstractDaoJdbcImp implements WorkDao {

    public WorkDaoJdbcImp(SingletonConnection singletonConnection) {
        super(singletonConnection);
    }

    //language=SQL
    private final String SQL_SELECT_ALL = "SELECT * FROM black_studio.master_works;";

    //language=SQL
    private final String SQL_SELECT_BY_ID =
            "SELECT * FROM black_studio.master_works WHERE id_master = ?";

    //language=SQL
    private final String SQL_INSERT_WORK ="INSERT INTO black_studio.master_works(url_work) VALUES (?) ";

    //language=SQL
    private final String SQL_UPDATE_WORK ="UPDATE black_studio.master_works SET url_work = ?";

    //language=MySQL
    public static final String SQL_DELETE_WORK = "" +
            "DELETE FROM black_studio.master_works WHERE id_master = ?";


    private RowMapper<Work> rowMapper = resultSet -> new Work()
            .setMasterId(resultSet.getInt("id_master"))
            .setUrlWork(resultSet.getString("url_work"));

    @Override
    public List<Work> findAll() {
        try {
            return queryOfMany(rowMapper, SQL_SELECT_ALL);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<Work> find(Integer id) {
        try {
            return queryOfFirst(rowMapper, SQL_SELECT_BY_ID, id);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean save(Work model) {
        try {
            Optional<Integer> id = queryOfSecond(x -> x.getInt("LAST_INSERT_ID()"),
                    SQL_INSERT_WORK, model.getUrlWork());
            id.ifPresent(model::setId);
            return id.isPresent();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Work model) {
        try {
            return update(SQL_UPDATE_WORK, model.getId(),
                    model.getUrlWork()) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            return update(SQL_DELETE_WORK, id) > 0;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

//    @Override
//    public Optional<Work> findByName(String name) {
//        return Optional.empty();
//    }
//
//    public Optional<Work> findById(int masterId) {
//        try {
//            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
//            statement.setInt(1, masterId);
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

//    @Override
//    public List<Work> findAll() {
//        try {
//            List<Work> works = new ArrayList<>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
//            while (resultSet.next()) {
//                int masterId = resultSet.getInt("masterId");
//                String urlWork = resultSet.getString("urlWork");
//                Work work = new Work(masterId, urlWork);
//
//                works.add(work);
//            }
//            return works;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    @Override
//    public List<Work> findAllById(int masterId) {
//        try {
//            List<Work> works = new ArrayList<>();
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL);
//            while (resultSet.next()) {
//                String urlWork = resultSet.getString("urlWork");
//                Work work = new Work(masterId, urlWork);
//
//                works.add(work);
//            }
//            return works;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
}
