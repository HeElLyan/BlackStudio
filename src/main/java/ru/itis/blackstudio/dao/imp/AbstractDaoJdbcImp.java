package ru.itis.blackstudio.dao.imp;

import ru.itis.blackstudio.dao.RowMapper;
import ru.itis.blackstudio.utils.SingletonConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDaoJdbcImp {

    private SingletonConnection singletonConnection;

    public AbstractDaoJdbcImp(SingletonConnection singletonConnection) {
        this.singletonConnection = singletonConnection;
    }

    private PreparedStatement prepare(String sql, Object... objects) throws SQLException {
        PreparedStatement stmt = singletonConnection.getConnection().prepareStatement(sql);
        for (int i = 0; i < objects.length; i++)
            stmt.setObject(i + 1, objects[i]);
        return stmt;
    }

    protected int update(String sql, Object... objects) throws SQLException {
        return prepare(sql, objects).executeUpdate();
    }

    protected <T> List<T> queryOfMany(RowMapper<T> mapper, String sql, Object... objects) throws SQLException {
        ResultSet resultSet = prepare(sql, objects).executeQuery();
        List<T>   results   = new ArrayList<>();
        while (resultSet.next())
            results.add(mapper.rowMap(resultSet));
        return results;
    }

    protected <T> Optional<T> queryOfNth(int n, RowMapper<T> mapper, String sql, Object... objects) throws SQLException {
        PreparedStatement stmt = prepare(sql, objects);
        stmt.execute();
        for (int i = 0; i < n - 1; i++)
            stmt.getMoreResults();
        ResultSet resultSet = stmt.getResultSet();
        if (resultSet != null && resultSet.next())
            return Optional.of(mapper.rowMap(resultSet));
        else return Optional.empty();
    }

    // return mapped object of second result set
    protected <T> Optional<T> queryOfSecond(RowMapper<T> mapper, String sql, Object... objects) throws SQLException {
        return queryOfNth(2, mapper, sql, objects);
    }

    protected <T> Optional<T> queryOfFirst(RowMapper<T> mapper, String sql, Object... objects) throws SQLException {
        return queryOfNth(1, mapper, sql, objects);
    }

}
