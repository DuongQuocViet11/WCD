package com.restaurant.restaurant.controller.admin.food;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.entity.myenum.FoodStatus;
import com.restaurant.restaurant.model.CategoryModel;
import com.restaurant.restaurant.model.FoodModel;
import com.restaurant.restaurant.model.MySqlCategoryModel;
import com.restaurant.restaurant.model.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateFoodServlet extends HttpServlet {
    private FoodModel foodModel;
    private CategoryModel categoryModel;

    public CreateFoodServlet() {
        this.foodModel = new MySqlFoodModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories", categoryModel.findAll());
        req.setAttribute("obj", new Food());
        req.setAttribute("breadcrumb", "Create New");
        req.setAttribute("title", "Create Food");
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        int categoryId = Integer.parseInt( req.getParameter("categoryId"));
        int status = Integer.parseInt( req.getParameter("status"));
        String description = req.getParameter("description");
        String thumbnail = req.getParameter("thumbnail");
        double price = Double.parseDouble(req.getParameter("price"));

        Food food = new Food();
        food.setName(name);
        food.setCategoryId(categoryId);
        food.setStatus(FoodStatus.of(status));
        food.setDescription(description);
        food.setThumbnail(thumbnail);
        food.setPrice(price);

        if(!food.isValid()){
            req.setAttribute("categories", categoryModel.findAll());
            req.setAttribute("obj", food);
            req.setAttribute("action", 1);
            req.setAttribute("errors", food.getErrors());
            req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
            return;
        }
        if (foodModel.save(food) != null) {
            resp.sendRedirect("/admin/food/list");
        } else {
            req.setAttribute("categories", categoryModel.findAll());
            req.setAttribute("obj", food);
            req.setAttribute("action", 1);
            req.setAttribute("errors", food.getErrors());
            req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
        }
    }
}
