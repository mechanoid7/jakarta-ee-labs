package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Database.ManageGroups;
import com.example.jakartaeelabs.Models.Group;
import com.example.jakartaeelabs.Models.Student;
import com.example.jakartaeelabs.Utils.CookieUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "groupsServlet", value = "/groups")
public class GroupsController extends HttpServlet {
    //    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Group> groups = ManageGroups.getAllGroups();

        Boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        req.setAttribute("groups", groups);
        req.setAttribute("editable", editable);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/groups.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

//        delete here
    }
}
