package com.example.jakartaeelabs.Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang.StringEscapeUtils;
import java.io.IOException;

@WebServlet(name = "groupsServlet", value = "/groups123")
public class GroupsServlet extends HttpServlet {

    public void init() {
    }

//    Example of escaping html for prevent XSS
//    String text = "<script>alert('Hello');</script>";
//    String escapedText = StringEscapeUtils.escapeHtml(text);


//    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get
        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/templates/groups.jsp");
        dispatcher.include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        // create if haven`t ID, else - edit
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
        // del
    }

    public void destroy() {
    }
}