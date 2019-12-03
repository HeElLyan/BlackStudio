package ru.itis.blackstudio.client;

import ru.itis.blackstudio.dao.imp.MasterDaoJdbcImp;
import ru.itis.blackstudio.dao.imp.ReviewDaoJdbcImp;
import ru.itis.blackstudio.dao.imp.UserDaoJdbcImp;
import ru.itis.blackstudio.dao.imp.WorkDaoJdbcImp;
import ru.itis.blackstudio.dao.MasterDao;
import ru.itis.blackstudio.dao.ReviewDao;
import ru.itis.blackstudio.dao.UserDao;
import ru.itis.blackstudio.dao.WorkDao;
import ru.itis.blackstudio.utils.SingletonConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DaoPool implements ServletContextListener {
    private static WorkDao workDao;
    private static UserDao userDao;
    private static ReviewDao reviewDao;
    private static MasterDao masterDao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SingletonConnection singletonConnection = new SingletonConnection();
        workDao = new WorkDaoJdbcImp(singletonConnection);
        userDao = new UserDaoJdbcImp(singletonConnection);
        reviewDao = new ReviewDaoJdbcImp(singletonConnection);
        masterDao = new MasterDaoJdbcImp(singletonConnection);
    }

    public static WorkDao getWorkDao() {
        return workDao;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static ReviewDao getReviewDao() {
        return reviewDao;
    }

    public static MasterDao getMasterDao() {
        return masterDao;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
