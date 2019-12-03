package ru.itis.blackstudio.services;

import ru.itis.blackstudio.services.imp.*;

public class ServiceFactory {
    public static Auth auth() {
        return new Auth();
    }

    public static MasterService masterService() {
        return new MasterService();
    }

    public static WorkService workService() {
        return new WorkService();
    }

    public static ReviewService reviewService() {
        return new ReviewService();
    }

    public static UserService userService() {
        return new UserService();
    }
}
