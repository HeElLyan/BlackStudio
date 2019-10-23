package ru.itis.blackstudio.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.blackstudio.models.Session;
import ru.itis.blackstudio.models.User;

import javax.activation.DataSource;
import java.sql.ResultSet;
import java.util.*;

public class UsersDaoJDBCTemplateImp implements UsersDao {
    private JdbcTemplate template;

    private final String SQL_SELECT_ALL =
            "SELECT * FROM black_studio.client";

    private Map<Integer, User> usersMap = new HashMap<>();

    //language=SQL
    private final String SQL_SELECT_USER_WITH_SESSION =
            "SELECT black_studio.client.*, black_studio.timetable.id_client as session, black_studio.timetable.session FROM black_studio.client LEFT JOIN black_studio.timetable ON black_studio.client.id_client = black_studio.timetable.id_client WHERE black_studio.client.id_client = ?";

    //language=SQL
    private final String SQL_SELECT_ALL_BY_USERNAME =
            "SELECT * FROM black_studio.client WHERE username = ?";

    UsersDaoJDBCTemplateImp(DataSource dataSource) {
        this.template = new JdbcTemplate((javax.sql.DataSource) dataSource);
    }

    private RowMapper<User> userRowMapper
            = (ResultSet resultSet, int i) -> {
        Integer id = resultSet.getInt("id");

        if (!usersMap.containsKey(id)) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            User user = new User(id, username, password, new ArrayList<>());
            usersMap.put(id, user);
        }

        Session session = new Session(resultSet.getInt("session"),
                resultSet.getString("session"), usersMap.get(id));

        usersMap.get(id).getSessions().add(session);

        return usersMap.get(id);
    };

    UsersDaoJDBCTemplateImp(DriverManagerDataSource dataSource) {
    }

    @Override
    public List<User> findAllByUsername(String username) {
        return template.query(SQL_SELECT_ALL_BY_USERNAME, userRowMapper, username);
    }

    @Override
    public Optional<User> find(Integer id) {
        template.query(SQL_SELECT_USER_WITH_SESSION, userRowMapper, id);

        if (usersMap.containsKey(id)) {
            return Optional.of(usersMap.get(id));
        }
        return Optional.empty();
    }

    @Override
    public void save(User model) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(User model) {

    }

    @Override
    public List<User> findAll() {
        return template.query(SQL_SELECT_ALL, userRowMapper);
    }

}
