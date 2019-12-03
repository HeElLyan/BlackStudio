package ru.itis.blackstudio.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class SingletonConnection implements Closeable {

    private Connection connection;

    public Connection getConnection() {
        try {
            if (Objects.isNull(connection) || connection.isClosed())
                instantiate();
            return connection;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private void instantiate() {
        try {
            String dbUrl      = "jdbc:mysql://localhost:3306/black_studio?useUnicode=true&serverTimezone=UTC";
            String dbUsername = "root";
            String dbPassword = "vjhrjdm[fym";

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (ClassNotFoundException | SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}

//
//@WebListener
//public class SingletonConnection implements ServletContextListener {
//
//    private Connection connection;
//
//    public Connection getConnection() {
//        try {
//            if (Objects.isNull(connection) || connection.isClosed())
//                instantiate();
//            return connection;
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    @Override
//    public void contextInitialized(ServletContextEvent servletContextEvent) {
//        Properties properties = new Properties();
//
//        try {
//            properties.load(new FileInputStream(servletContextEvent.getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
//            String dbUrl = properties.getProperty("db.url");
//            String dbUsername = properties.getProperty("db.username");
//            String dbPassword = properties.getProperty("db.password");
//            String driverClassName = properties.getProperty("db.driverClassName");
//
//            Class.forName(driverClassName);
//            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//        } catch (IOException | SQLException | ClassNotFoundException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent servletContextEvent) {
//          try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new IllegalStateException(e);
//        }
//    }
//}
//
