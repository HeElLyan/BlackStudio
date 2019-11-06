package ru.itis.blackstudio.servlets;

import ru.itis.blackstudio.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class  UsersServletWithDao extends HttpServlet {
    private UsersDao usersDao;
//
//    @Override
//    public void init() throws ServletException {
//        Properties properties = new Properties();
//        DriverManagerDataSource dataSource =
//                new DriverManagerDataSource();
//
//        try {
//            properties.load(new FileInputStream(getServletContext().getRealPath("/WEB-INF/classes/db.properties")));
//            String dbUrl = properties.getProperty("db.url");
//            String dbUsername = properties.getProperty("db.username");
//            String dbPassword = properties.getProperty("db.password");
//            String driverClassName = properties.getProperty("db.driverClassName");
//
//            dataSource.setUsername(dbUsername);
//            dataSource.setPassword(dbPassword);
//            dataSource.setUrl(dbUrl);
//            dataSource.setDriverClassName(driverClassName);
//
//            usersDao = new UsersDaoJDBCTemplateImp(dataSource);
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Optional<User> user = usersDao.find(1);
//        int i = 0;
//
//        List<User> users = null;
//        if (req.getParameter("firstName") != null) {
//            String firstName = req.getParameter("firstName");
//            users = usersDao.findAllByUsername(firstName);
//        } else {
//            users = usersDao.findAll();
//        }
//        req.setAttribute("usersFromServer", users);
//        req.getServletContext().getRequestDispatcher("/jsp/users.jsp").forward(req, resp);
//    }
    }
}
