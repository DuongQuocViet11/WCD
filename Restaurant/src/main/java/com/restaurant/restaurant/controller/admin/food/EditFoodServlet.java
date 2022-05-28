package com.restaurant.restaurant.controller.admin.food;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.entity.myenum.FoodStatus;
import com.restaurant.restaurant.model.MySqlCategoryModel;
import com.restaurant.restaurant.model.MySqlFoodModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditFoodServlet extends HttpServlet {
    private MySqlFoodModel foodModel;
    private MySqlCategoryModel categoryModel;

    public EditFoodServlet() {
        this.foodModel = new MySqlFoodModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Food food = foodModel.findbyId(id);
        if (food == null){
            req.setAttribute("Message", "Food not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            req.setAttribute("breadcrumb","Edit");
            req.setAttribute("title", "Edit Food");
            req.setAttribute("obj", food);
            req.setAttribute("action", 2);
            req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Food existingProduct = foodModel.findbyId(id);
        if(existingProduct == null){
            req.setAttribute("message", "Food not found");
            req.getRequestDispatcher("/admin/errors/404.jsp").forward(req, resp);
        }else {
            id = Integer.parseInt("id");
            String name = req.getParameter("name");
            int categoryId = Integer.parseInt( req.getParameter("categoryId"));
            int status = Integer.parseInt( req.getParameter("status"));
            String description = req.getParameter("description");
            String thumbnail = req.getParameter("thumbnail");
            double price = Double.parseDouble(req.getParameter("price"));
            Food food = new Food();
            food.setId(id);
            food.setName(name);
            food.setCategoryId(categoryId);
            food.setStatus(FoodStatus.of(status));
            food.setDescription(description);
            food.setThumbnail(thumbnail);
            food.setPrice(price);

            if (!existingProduct.isValid()){
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("title", "Edit Food");
                req.setAttribute("obj", food);
                req.setAttribute("action", 2);
                req.setAttribute("errors", food.getErrors());
                req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
            }
            if (foodModel.update(id, food) != null){
                resp.sendRedirect("/admin/food/list");
            }else {
                req.setAttribute("categories", categoryModel.findAll());
                req.setAttribute("breadcrumb","Edit");
                req.setAttribute("title", "Edit Food");
                req.setAttribute("obj", food);
                req.setAttribute("action", 2);
                req.setAttribute("errors", food.getErrors());
                req.getRequestDispatcher("/admin/food/form.jsp").forward(req, resp);
            }
        }
    }

}
