package com.example.loginandregister.controller;

import com.example.loginandregister.entity.Account;
import com.example.loginandregister.model.AcountModel;
import com.example.loginandregister.model.MySqlAccountModel;
import com.example.loginandregister.util.MD5Hasher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private AcountModel acountModel;

    public LoginServlet(){
        this.acountModel = new MySqlAccountModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = acountModel.findByUsername(username);
        if (account != null) {
            boolean loginSucces = MD5Hasher.checkPassword(account.getPasswordHash(), password, account.getSalt());
            if (!loginSucces) {
                account.addErrors("username", "Invalid information");
            }
        } else {
            account = new Account();
            account.addErrors("username", "Invalid information");
        }
        if (account.getListErrors().size() > 0) {
            req.setAttribute("account", account);
            req.getRequestDispatcher("/admin/login.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("currentLogin", account);
            resp.sendRedirect("/admin/home");
        }
    }
}
