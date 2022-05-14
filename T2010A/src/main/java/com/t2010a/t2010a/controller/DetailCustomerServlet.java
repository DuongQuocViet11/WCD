package com.t2010a.t2010a.controller;

import com.t2010a.t2010a.entity.Customer;
import com.t2010a.t2010a.model.CustomerModel;
import com.t2010a.t2010a.model.MySqlCustomerModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailCustomerServlet extends HttpServlet {
    private CustomerModel customerModel;

    public DetailCustomerServlet() {
        this.customerModel = new MySqlCustomerModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy tham số (cusID)
        String cusID = req.getParameter("id");
        //Kiểm tra xem trong database có tồn tại
        Customer customer = customerModel.findById(cusID);
        //nếu không trả về trang 404
        if (customer == null){
            req.setAttribute("Message", "Customer not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("customer", customer);
            req.getRequestDispatcher("/admin/customers/detail.jsp").forward(req, resp);
        }
    }
}
