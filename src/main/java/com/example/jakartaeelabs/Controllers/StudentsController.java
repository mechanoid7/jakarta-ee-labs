package com.example.jakartaeelabs.Controllers;

import com.example.jakartaeelabs.Database.ManageGroups;
import com.example.jakartaeelabs.Database.ManageStudents;
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
import java.util.List;
import java.util.Objects;

@WebServlet(name = "studentsServlet", value = "/students")
public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String groupId = req.getParameter("groupId");
        Group group = ManageGroups.getGroupById(Integer.parseInt(groupId));

        List<Student> students = ManageStudents.getStudentsByGroupId(Integer.parseInt(groupId));

        Boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        req.setAttribute("students", students);
        req.setAttribute("groupId", groupId);
        req.setAttribute("groupName", group.getName());
        req.setAttribute("editable", editable);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/students.jsp");
        requestDispatcher.forward(req, resp);

//        TODO: add forward to 404 if group not found
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ManageStudents.deleteById(Integer.parseInt(id));
    }
}
