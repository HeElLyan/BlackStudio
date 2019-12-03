package ru.itis.blackstudio.filters;

import ru.itis.blackstudio.constants.Attributes;
import ru.itis.blackstudio.constants.Urls;
import ru.itis.blackstudio.models.User;
import ru.itis.blackstudio.services.ServiceFactory;
import ru.itis.blackstudio.utils.CookiesUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebFilter("/*")
public class SessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = ((HttpServletResponse) servletResponse);
        HttpServletRequest  request  = ((HttpServletRequest) servletRequest);

        HttpSession session          = request.getSession(false);
        boolean     isSessionCorrect = Objects.nonNull(session) && Objects.nonNull(session.getAttribute("current_user"));

        if (!isSessionCorrect) {
            Cookie[] cookies = ((HttpServletRequest) servletRequest).getCookies();
            if (cookies != null) {
                int id = CookiesUtil.getUserIdKey(request);

                if (id != -1) {
                    User user = ServiceFactory.userService()
                            .find(id)
                            .orElseThrow(IllegalStateException::new);
                    session = request.getSession(true);
                    session.setAttribute(Attributes.SESSION_USER_KEY, user);
                    isSessionCorrect = true;
                }
            }

        }

        String uri       = ((HttpServletRequest) servletRequest).getServletPath();
//        String uriEnding = uri.substring(uri.lastIndexOf("/"));

        if (uri.equals(Urls.LOGIN) || uri.equals(Urls.REGISTER)) {
            if (isSessionCorrect) {
//                response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.GENERAL);
                response.sendRedirect(request.getContextPath() + Urls.MAIN);
                return;
            }
        } else {
            if (!isSessionCorrect) {
//                response.sendRedirect(ServletKeys.CONTEXT_PATH + Urls.LOGIN_NOT_LOGGED);
                response.sendRedirect(request.getContextPath() + Urls.LOGIN);
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
