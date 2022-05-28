package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Food;
import com.restaurant.restaurant.entity.myenum.CategoryStatus;
import com.restaurant.restaurant.entity.myenum.FoodStatus;
import com.restaurant.restaurant.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlFoodModel implements FoodModel{
    @Override
    public Food save(Food food) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="insert into food" +
                    "(categoryId, name, description, thumbnail, price, createdAt, updatedAt, status)" +
                    "values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, food.getCategoryId());
            preparedStatement.setString(2, food.getName());
            preparedStatement.setString(3, food.getDescription());
            preparedStatement.setString(4, food.getThumbnail());
            preparedStatement.setDouble(5, food.getPrice());
            preparedStatement.setString(6, food.getCreatedAt().toString());
            preparedStatement.setString(7, food.getUpdatedAt().toString());
            preparedStatement.setInt(8, food.getStatus().getValue());
            preparedStatement.execute();
            System.out.println("Action success");
            return food;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Food> findAll() {
        List<Food> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from food where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodStatus.DANGBAN.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                Food food = new Food();
                food.setId(id);
                food.setCategoryId(categoryId);
                food.setName(name);
                food.setDescription(description);
                food.setThumbnail(thumbnail);
                food.setPrice(price);
                food.setCreatedAt(createdAt);
                food.setUpdatedAt(updatedAt);
                food.setStatus(FoodStatus.of(intStatus));
                list.add(food);
            }
            System.out.println("Action success");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Food findbyId(int id) {
        Food food = null;
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from food where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodStatus.DANGBAN.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                int categoryId = resultSet.getInt("categoryId");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String thumbnail = resultSet.getString("thumbnail");
                double price = resultSet.getDouble("price");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                food = new Food();

                food.setCategoryId(categoryId);
                food.setName(name);
                food.setDescription(description);
                food.setThumbnail(thumbnail);
                food.setPrice(price);
                food.setCreatedAt(createdAt);
                food.setUpdatedAt(updatedAt);
                food.setStatus(FoodStatus.of(intStatus));
            }
            System.out.println("Action success");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return food;
    }

    @Override
    public Food update(int id, Food updateFood) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  food " +
                    "set categoryId = ?, name = ?, description = ?, thumbnail = ?, price = ?, createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, updateFood.getCategoryId());
            preparedStatement.setString(2, updateFood.getName());
            preparedStatement.setString(3, updateFood.getDescription());
            preparedStatement.setString(4, updateFood.getThumbnail());
            preparedStatement.setDouble(5, updateFood.getPrice());
            preparedStatement.setString(6, updateFood.getCreatedAt().toString());
            preparedStatement.setString(7, updateFood.getUpdatedAt().toString());
            preparedStatement.setInt(8, updateFood.getStatus().getValue());
            preparedStatement.setInt(9, id);
            preparedStatement.execute();
            System.out.println("Action success");
            return updateFood;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  food " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, FoodStatus.DELETE.getValue());
            preparedStatement.setInt(2, id);
            preparedStatement.execute();
            System.out.println("Action success");
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
