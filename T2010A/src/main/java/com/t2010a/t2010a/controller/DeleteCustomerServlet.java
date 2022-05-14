package com.t2010a.t2010a.controller;

import com.t2010a.t2010a.entity.Customer;
import com.t2010a.t2010a.model.CustomerModel;
import com.t2010a.t2010a.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public DeleteCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusID = req.getParameter("id");
        Customer customer = customerModel.findById(cusID);
        if (customer == null){
            req.setAttribute("message", "Customer not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            boolean result = customerModel.delete(cusID);
            if (result){
                resp.sendRedirect("/admin/customers/list");
            }else {
                req.setAttribute("message", "Action fails");
                req.getRequestDispatcher("/admin/errors/505.jsp").forward(req, resp);
            }
        }
    }
}
