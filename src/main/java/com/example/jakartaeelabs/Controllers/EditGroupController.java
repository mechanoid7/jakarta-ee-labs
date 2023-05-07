package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Models.Group;
import com.example.jakartaeelabs.Utils.CookieUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "editGroupServlet", value = "/edit-group")
public class EditGroupController extends HttpServlet {
    //    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TODO: add get Group from db

        Group group = new Group("IO-test");

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
        //    TODO: Add escaping text on edit
        //    Example of escaping html for prevent XSS:
        //    String text = "<script>alert('Hello');</script>";
        //    String escapedText = StringEscapeUtils.escapeHtml(text);

//        TODO: add redirect to /groups

        // create if haven`t ID in DB, else - edit(update)
    }
}
