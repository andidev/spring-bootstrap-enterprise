package org.andidev.applicationname.config.interceptor;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import static org.andidev.applicationname.util.ApplicationUtils.getUser;
import static org.andidev.applicationname.util.ApplicationUtils.isAuthenticatedUser;
import static org.andidev.applicationname.util.StringUtils.quote;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

@Slf4j
@RequiredArgsConstructor
public abstract class ParameterInterceptor<T> extends HandlerInterceptorAdapter {

    private CookieGenerator cookieGenerator = new CookieGenerator();
    @Setter
    @NonNull
    private String parameterName;

    @PostConstruct
    public void init() {
        cookieGenerator.setCookieName(parameterName);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        T paramter;
        if (isAuthenticatedUser()) {
            boolean parameterIsRemoved = isParameterFromRequestEmptyString(request);
            if (parameterIsRemoved) {
                log.trace("Removing {} from session", parameterName);
                setParameterInSession(request.getSession(), null);
            }

            paramter = getParameterFromRequest(request);
            if (paramter != null && !parameterIsRemoved) {
                log.trace("Setting {} to {} from parameter", parameterName, quote(paramter));
                setParameterHolder(paramter);
                log.trace("Setting {} to {} in session", parameterName, quote(paramter));
                setParameterInSession(request.getSession(), paramter);
                return true;
            }

            paramter = getParameterFromSession(request.getSession());
            if (paramter != null && !parameterIsRemoved) {
                log.trace("Setting {} to {} from session", parameterName, quote(paramter));
                setParameterHolder(paramter);
                return true;
            }

            paramter = getParameterFromUserSettings(getUser());
            if (paramter != null) {
                log.trace("Setting {} to {} from user settings", parameterName, quote(paramter));
                setParameterHolder(paramter);
                return true;
            }

            paramter = getDefaultValue();
            log.trace("Setting {} to {} from default value", parameterName, quote(paramter));
            setParameterHolder(paramter);
            return true;
        } else {
            boolean parameterIsRemoved = isParameterFromRequestEmptyString(request);
            if (parameterIsRemoved) {
                log.trace("Removing {} from cookie", parameterName);
                setParameterInCookie(response, null);
            }

            paramter = getParameterFromRequest(request);
            if (paramter != null && !parameterIsRemoved) {
                log.trace("Setting {} to {} from parameter", parameterName, quote(paramter));
                setParameterHolder(paramter);
                log.trace("Setting {} to {} in cookie", parameterName, quote(paramter));
                setParameterInCookie(response, paramter);
                return true;
            }

            paramter = getParameterFromCookie(request);
            if (paramter != null && !parameterIsRemoved) {
                log.trace("Setting {} to {} from cookie", parameterName, quote(paramter));
                setParameterHolder(paramter);
                return true;
            }

            paramter = getDefaultValue();
            log.trace("Setting {} to {} from default value", parameterName, quote(paramter));
            setParameterHolder(paramter);
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        resetParameterHolder();
    }

    protected boolean isParameterFromRequestEmptyString(HttpServletRequest request) {
        return "".equals(request.getParameter(parameterName));
    }

    protected T getParameterFromRequest(HttpServletRequest request) {
        String parameter = request.getParameter(parameterName);
        if (parameter == null || parameter.equals("")) {
            return null;
        }
        return parseParameter(parameter);
    }

    protected T getParameterFromCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, parameterName);
        if (cookie == null) {
            return null;
        }
        return parseParameter(cookie.getValue());
    }

    protected void setParameterInCookie(HttpServletResponse response, T parameter) {
        if (parameter == null) {
            cookieGenerator.removeCookie(response);
        } else {
            cookieGenerator.addCookie(response, printParameter(parameter));
        }
    }

    protected T getParameterFromSession(HttpSession session) {
        return (T) session.getAttribute(parameterName);
    }

    protected void setParameterInSession(HttpSession session, T parameter) {
        session.setAttribute(parameterName, parameter);
    }

    protected abstract String printParameter(T parameter);

    protected abstract T parseParameter(String parameter);

    protected abstract T getParameterFromUserSettings(User user);

    protected abstract void setParameterHolder(T parameter);

    protected abstract void resetParameterHolder();

    protected abstract T getDefaultValue();
}