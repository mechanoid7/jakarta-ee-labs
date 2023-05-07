package com.example.jakartaeelabs.Utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class CookieUtils {
    public static final String EDITABLE_COOKIE_PARAM_NAME = "editable";

    public static void saveCookie(HttpServletResponse response, String name, String value) {
        response.addCookie(new Cookie(name, value));
    }

    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }
}
