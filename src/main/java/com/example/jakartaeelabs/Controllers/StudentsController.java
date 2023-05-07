package com.example.jakartaeelabs.Controllers;

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

@WebServlet(name = "studentsServlet", value = "/students")
public class StudentsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String group = req.getParameter("group");
        System.out.println(">>> PARAMETER: " + group);

//      TODO: get students by group


//        List<Group> groups = new ArrayList<>();
//        List<Student> students_IO_99 = new ArrayList<>();
//        students_IO_99.add(new Student("IO-99", "John", "Doe"));
//        students_IO_99.add(new Student("IO-99", "Jane", "Smith"));
//        students_IO_99.add(new Student("IO-99", "Bob", "Johnson"));
        List<Student> students = new ArrayList<>();
        students.add(new Student("IO-99", "John", "Doe"));
        students.add(new Student("IO-99", "Jane", "Smith"));
        students.add(new Student("IO-99", "Bob", "Johnson"));

//        groups.add(new Group("IO-99", students_IO_99));
//        groups.add(new Group("IO-10", students_IO_10));


        Boolean editable = Objects.equals(CookieUtils.getCookie(req, CookieUtils.EDITABLE_COOKIE_PARAM_NAME), "true");

        req.setAttribute("students", students);
        req.setAttribute("editable", editable);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/students.jsp");
        requestDispatcher.forward(req, resp);

//        TODO: add forward to 404 if group not found
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/templates/404.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

//        delete here
    }
}
