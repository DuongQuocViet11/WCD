package com.t2010a.t2010a.controller;

import com.t2010a.t2010a.entity.Customer;
import com.t2010a.t2010a.model.CustomerModel;
import com.t2010a.t2010a.model.MySqlCustomerModel;
import com.t2010a.t2010a.util.DateTimeHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public CreateCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customer", new Customer());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //xử lý validate và save
        String cusID = req.getParameter("cusID");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String image = req.getParameter("image");
        String stringBirthday = req.getParameter("dob");

        LocalDateTime dob = DateTimeHelper.convertStringToLocalDateTime(stringBirthday);
        Customer customer = new Customer(cusID, name, phone, image, dob);
        //validate dữ liệu
        if (customerModel.save(customer) != null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
