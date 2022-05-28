package com.restaurant.restaurant.controller.admin.food;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.model.FoodModel;
import com.restaurant.restaurant.model.MySqlFoodModel;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    public DeleteFoodServlet() {
        this.foodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodModel.findbyId(id);
        if (food == null){
            req.setAttribute("message", "Food not found!");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            boolean result = foodModel.delete(id);
            if (result){
                resp.sendRedirect("/admin/food/list");
            }else {
                req.setAttribute("message", "Action fails");
                req.getRequestDispatcher("/admin/errors/505.jsp").forward(req, resp);
            }
        }
    }
}
