package com.restaurant.restaurant.controller.admin.food;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.model.FoodModel;
import com.restaurant.restaurant.model.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DetailFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    public DetailFoodServlet() {
        this.foodModel = new MySqlFoodModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodModel.findbyId(id);
        if (food == null){
            req.setAttribute("Message", "Food not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("title", "Food Detail");
            req.setAttribute("food", food);
            req.getRequestDispatcher("/admin/food/detail.jsp").forward(req, resp);
        }
    }
}
