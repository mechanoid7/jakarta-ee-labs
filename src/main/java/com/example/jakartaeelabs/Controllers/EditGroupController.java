package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Database.ManageGroups;
import com.example.jakartaeelabs.Models.Group;
import com.example.jakartaeelabs.Utils.CookieUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringEscapeUtils;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "editGroupServlet", value = "/edit-group")
public class EditGroupController extends HttpServlet {
    //    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id"); // group id, if exist - return group with ID {new Group("name", "id")}
        Group group = new Group("");

        if (id != null) {
            group = ManageGroups.getGroupById(Integer.parseInt(id));
        }

        boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        if (!editable) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/404.jsp");
            requestDispatcher.forward(req, resp);
        }

        req.setAttribute("group", group);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/edit-group.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String name = StringEscapeUtils.escapeHtml(req.getParameter("name")); // escape HTML

        if (id == null || id.equals("")) {
            ManageGroups.insert(name);
        } else {
            ManageGroups.update(Integer.parseInt(id), name);
        }

        resp.sendRedirect("/groups");
    }
}
