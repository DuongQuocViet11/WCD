package com.example.exampaper.controller;

import com.example.exampaper.entity.Brand;
import com.example.exampaper.entity.Phone;
import com.example.exampaper.model.BrandModel;
import com.example.exampaper.model.MySqlBrandModel;
import com.example.exampaper.model.MySqlPhoneModel;
import com.example.exampaper.model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListPhoneServlet extends HttpServlet {
    private PhoneModel phoneModel;
    private BrandModel brandModel;
    public ListPhoneServlet() {
        this.phoneModel = new MySqlPhoneModel();
        this.brandModel = new MySqlBrandModel();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Phone> list = phoneModel.findAll();
        List<Brand> listBrand = brandModel.findAll();
        request.setAttribute("title","List Phone");
        request.setAttribute("list",list);
        request.setAttribute("listBrand",listBrand);

        request.getRequestDispatcher("/admin/phones/list.jsp").forward(request,response);
    }
}
