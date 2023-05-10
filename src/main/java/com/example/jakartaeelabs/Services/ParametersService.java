package com.example.jakartaeelabs.Services;

import jakarta.ejb.Singleton;
import jakarta.ejb.Stateless;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringEscapeUtils;

@Singleton
public class ParametersService {
    public String getEscaped(HttpServletRequest req, String paramName) {
        return StringEscapeUtils.escapeHtml(req.getParameter(paramName));
    }
}
