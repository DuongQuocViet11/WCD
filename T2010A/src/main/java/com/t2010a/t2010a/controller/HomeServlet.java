package com.t2010a.t2010a.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        //setAttribute dùng để gửi dữ liệu ra JSP
        request.setAttribute("firstName", firstName);
        request.setAttribute("lastName", lastName);
        //xử lý logic
        //xử lý, lấy dữ liệu ở database.
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}
