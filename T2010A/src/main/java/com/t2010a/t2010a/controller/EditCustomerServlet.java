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

public class EditCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public EditCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusID = req.getParameter("id");
        Customer customer = customerModel.findById(cusID);
        if (customer == null){
            req.setAttribute("Message", "Customer not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("customer", customer);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cusID = req.getParameter("cusID");
        Customer existingCustomer = customerModel.findById(cusID);
        if(existingCustomer == null){
            req.setAttribute("message", "Customer not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            String name = req.getParameter("name");
            String phone = req.getParameter("phone");
            String image = req.getParameter("image");
            String stringDob = req.getParameter("dob");
            LocalDateTime dob = DateTimeHelper.convertStringToLocalDateTime(stringDob);
            Customer customer = new Customer(cusID, name, phone,image, dob);

            if (customerModel.update(cusID, customer) != null){
                resp.sendRedirect("/admin/customers/list");
            }else {
                req.setAttribute("customer", customer);
                req.setAttribute("action", 2);
                req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            }
        }
    }
}
