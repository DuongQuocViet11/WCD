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
import java.util.HashMap;

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
        String stringDob = req.getParameter("dob");
        Customer customer = new Customer(cusID, name, phone);
        HashMap<String, String> errors = new HashMap<>();
        if (stringDob != null && stringDob.length() >0){
            LocalDateTime dob = DateTimeHelper.convertStringToLocalDateTime(stringDob);
            customer.setDob(dob);
        }
        //validate dữ liệu theo kiểu cùi bắp
        if (cusID == null || cusID.length() == 0) {
            errors.put("cusID", "Please enter customer ID");
        }
        if (name == null || name.length() == 0) {
            errors.put("name", "Please enter name");
        }
        if (phone == null || phone.length() == 0) {
            errors.put("phone", "Please enter phone");
        }
        if(errors.size() > 0){
            req.setAttribute("customer", customer);
            req.setAttribute("action", 1);
            req.setAttribute("errors", errors);
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
            return;
        }
        if (customerModel.save(customer) != null){
            resp.sendRedirect("/admin/customers/list");
        }else {
            req.getRequestDispatcher("/admin/customers/form.jsp").forward(req, resp);
        }
    }
}
