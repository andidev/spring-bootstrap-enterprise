package org.andidev.applicationname.config.interceptor;

import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.andidev.applicationname.entity.User;
import static org.andidev.applicationname.util.ApplicationUtils.getUser;
import static org.andidev.applicationname.util.ApplicationUtils.isAuthenticatedUser;
import static org.andidev.applicationname.util.StringUtils.quote;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.i18n.SimpleLocaleContext;
import static org.springframework.util.StringUtils.parseLocaleString;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

@Slf4j
public class LocaleInterceptor extends HandlerInterceptorAdapter {

    private CookieGenerator cookieGenerator = new CookieGenerator();
    @Setter
    private String parameterName = "locale";
    @Setter
    private String sessionAttributeName = "locale";
    @Setter
    private String cookieName = "locale";
    @Setter
    private Locale defaultLocale = Locale.ENGLISH;

    @PostConstruct
    public void init() {
        cookieGenerator.setCookieName(cookieName);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Locale locale;
        if (isAuthenticatedUser()) {
            locale = getLocaleFromParameter(request);
            if (locale != null) {
                log.trace("Setting locale to {} from parameter", quote(locale));
                setLocaleInLocaleContextHolder(locale);
                log.trace("Setting locale to {} in session", quote(locale));
                setLocaleInSession(request.getSession(), locale);
                return true;
            }

            locale = getLocaleFromSession(request.getSession());
            if (locale != null) {
                log.trace("Setting locale to {} from session", quote(locale));
                setLocaleInLocaleContextHolder(locale);
                return true;
            }

            locale = getLocaleFromUserSettings(getUser());
            if (locale != null) {
                log.trace("Setting locale to {} from user settings", quote(locale));
                setLocaleInLocaleContextHolder(locale);
                return true;
            }

            locale = defaultLocale;
            log.trace("Setting locale to {} from default value", quote(locale));
            setLocaleInLocaleContextHolder(locale);
            return true;
        } else {
            locale = getLocaleFromParameter(request);
            if (locale != null) {
                log.trace("Setting locale to {} from parameter", quote(locale));
                setLocaleInLocaleContextHolder(locale);
                log.trace("Setting locale to {} in cookie", quote(locale));
                setLocaleInCookie(response, locale);
                return true;
            }

            locale = getLocaleFromCookie(request);
            if (locale != null) {
                log.trace("Setting locale to {} from cookie", quote(locale));
                setLocaleInLocaleContextHolder(locale);
                return true;
            }

            locale = defaultLocale;
            log.trace("Setting locale to {} from default value", quote(locale));
            setLocaleInLocaleContextHolder(locale);
            return true;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LocaleContextHolder.resetLocaleContext();
    }

    private Locale getLocaleFromParameter(HttpServletRequest request) {
        String paraneter = request.getParameter(parameterName);
        if (paraneter == null) {
            return null;
        }
        return parseLocaleString(paraneter);
    }

    private Locale getLocaleFromCookie(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        if (cookie == null) {
            return null;
        }
        return parseLocaleString(cookie.getValue());
    }

    private void setLocaleInCookie(HttpServletResponse response, Locale locale) {
        if (locale == null) {
            cookieGenerator.removeCookie(response);
        } else {
            cookieGenerator.addCookie(response, locale.toString());
        }
    }

    private Locale getLocaleFromSession(HttpSession session) {
        return (Locale) session.getAttribute(sessionAttributeName);
    }

    private void setLocaleInSession(HttpSession session, Locale locale) {
        session.setAttribute(sessionAttributeName, locale);
    }

    private Locale getLocaleFromUserSettings(User user) {
        return user.getLocale();
    }

    private void setLocaleInLocaleContextHolder(Locale locale) {
        LocaleContext context = new SimpleLocaleContext(locale);
        LocaleContextHolder.setLocaleContext(context);
    }
}