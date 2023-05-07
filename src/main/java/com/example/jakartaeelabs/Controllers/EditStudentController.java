package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Models.Group;
import com.example.jakartaeelabs.Models.Student;
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

@WebServlet(name = "editStudentServlet", value = "/edit-student")
public class EditStudentController extends HttpServlet {
    //    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TODO: add get Student from db if 'id' exists
        String groupId = req.getParameter("groupId");

        Student student = new Student("John", "Doe");

        boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        if (!editable) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/404.jsp");
            requestDispatcher.forward(req, resp);
        }

        req.setAttribute("student", student);
        req.setAttribute("groupId", groupId);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/edit-student.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getAttribute("groupId").toString();
        String id = req.getAttribute("id").toString(); // student id, if not exist - create
        String firstName = StringEscapeUtils.escapeHtml(req.getAttribute("firstName").toString()); // escape HTML
        String lastName = StringEscapeUtils.escapeHtml(req.getAttribute("lastName").toString()); // escape HTML

//        TODO: add redirect to /students?group=<STUDENT GROUP>

        // create if haven`t ID in DB, else - edit(update)
    }
}
