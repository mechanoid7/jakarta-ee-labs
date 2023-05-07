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
import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "groupsServlet", value = "/groups")
public class GroupsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Group> groups = new ArrayList<>();
        List<Student> students_IO_99 = new ArrayList<>();
        students_IO_99.add(new Student("IO-99", "John", "Doe"));
        students_IO_99.add(new Student("IO-99", "Jane", "Smith"));
        students_IO_99.add(new Student("IO-99", "Bob", "Johnson"));
        List<Student> students_IO_10 = new ArrayList<>();
        students_IO_10.add(new Student("IO-99", "John", "Doe"));
        students_IO_10.add(new Student("IO-99", "Jane", "Smith"));
        students_IO_10.add(new Student("IO-99", "Bob", "Johnson"));

        groups.add(new Group("IO-99", students_IO_99));
        groups.add(new Group("IO-10", students_IO_10));



        Boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        req.setAttribute("groups", groups);
        req.setAttribute("editable", editable);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/groups_v2.jsp");
        requestDispatcher.forward(req, resp);
    }
}
