package com.example.loginandregister.controller;

import com.example.loginandregister.entity.Account;
import com.example.loginandregister.model.AcountModel;
import com.example.loginandregister.model.MySqlAccountModel;
import com.example.loginandregister.util.MD5Hasher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private AcountModel acountModel;
    public RegisterServlet(){
        this.acountModel = new MySqlAccountModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("account", new Account());
        req.getRequestDispatcher("/admin/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setPasswordConfirm(confirmPassword);
        account.setEmail(email);
        account.setPhone(phone);
        if (acountModel.findByUsername(username) != null) {
            account.addErrors("username", "Username is exist.");
        }
        if (acountModel.findByEmail(email) != null) {
            account.addErrors("email", "Email is exist.");
        }
        if (account.isValid()) {
            account.setSalt(MD5Hasher.randomString(10));
            account.setPasswordHash(MD5Hasher.encode(account.getPassword(), account.getSalt()));
            acountModel.save(account);
            resp.sendRedirect("/admin/login");
        } else {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/admin/register.jsp").forward(req, resp);
        }
    }
}
