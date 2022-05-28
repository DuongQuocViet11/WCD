package com.restaurant.restaurant.controller.admin.food;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.model.FoodModel;
import com.restaurant.restaurant.model.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListFoodServlet extends HttpServlet {
    private FoodModel foodModel;

    public ListFoodServlet(){
        this.foodModel = new MySqlFoodModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Food> list = foodModel.findAll();
        req.setAttribute("list", list);
        req.setAttribute("title", "List Food");
        req.getRequestDispatcher("/admin/food/list.jsp").forward(req, resp);
    }
}
