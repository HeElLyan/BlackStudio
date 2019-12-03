package ru.itis.blackstudio.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class CookiesUtil {

    public static final String USER_ID_KEY           = "login";
    public static final int    COOKIES_REMEMBER_TIME = 30; // in seconds

    public static void remove(String key, HttpServletResponse resp) {
        Cookie cookie = new Cookie(key, "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
    }

    public static void removeUserId(HttpServletResponse resp) {
        remove(USER_ID_KEY, resp);
    }

    public static void add(String key, String value, HttpServletResponse resp) {
        Cookie cookie = new Cookie(key, value);
        resp.addCookie(cookie);
    }

    public static void add(String key, String value, int maxAge, HttpServletResponse resp) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }

    public static void addUserId(Integer id, HttpServletResponse resp) {
        add(USER_ID_KEY, id.toString(), COOKIES_REMEMBER_TIME, resp);
    }

    public static Optional<String> get(String key, HttpServletRequest req) {
        return Arrays.stream(req.getCookies())
                .filter(x -> x.getName().equals(key))
                .map(Cookie::getValue)
                .findFirst();
    }

    public static int getUserIdKey(HttpServletRequest req) {
        return get(USER_ID_KEY, req).map(Integer::parseInt).orElse(-1);
    }

}



