package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Database.ManageGroups;
import com.example.jakartaeelabs.Database.ManageStudents;
import com.example.jakartaeelabs.Models.Group;
import com.example.jakartaeelabs.Models.Student;
import com.example.jakartaeelabs.Services.ParametersService;
import com.example.jakartaeelabs.Utils.CookieUtils;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "editStudentServlet", value = "/edit-student")
public class EditStudentController extends HttpServlet {
    //    TODO: add return statuses, like "response.setStatus(HttpServletResponse.SC_OK);"

    @EJB
    ParametersService parametersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        String id = req.getParameter("id"); // student id, if exist - return student with ID {new Student("first name", "last name", "id")}

        Group group = ManageGroups.getGroupById(Integer.parseInt(groupId));

        Student student = new Student(Integer.parseInt(groupId), "", "");
        if (id != null) {
            student = ManageStudents.getStudentById(Integer.parseInt(id));
        }

        boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        if (!editable) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/404.jsp");
            requestDispatcher.forward(req, resp);
        }

        req.setAttribute("student", student);
        req.setAttribute("group", group);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/edit-student.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        String id = req.getParameter("id"); // student id, if not exist - create
        String firstName = parametersService.getEscaped(req, "firstName"); // escape HTML
        String lastName = parametersService.getEscaped(req, "lastName"); // escape HTML

        if (id == null || id.equals("")) {
            ManageStudents.insert(Integer.parseInt(groupId), firstName, lastName);
        } else {
            ManageStudents.update(Integer.parseInt(id), Integer.parseInt(groupId), firstName, lastName);
        }

        resp.sendRedirect("/students?groupId=" + groupId);
    }
}
