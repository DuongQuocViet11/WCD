package com.t2010a.t2010a.controller;

import com.t2010a.t2010a.model.CustomerModel;
import com.t2010a.t2010a.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ListCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public ListCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listCustomer", customerModel.findAll());
        req.getRequestDispatcher("/admin/customers/list.jsp").forward(req, resp);
    }
}
