package com.restaurant.restaurant.model;

import com.restaurant.restaurant.entity.Category;
import com.restaurant.restaurant.entity.myenum.CategoryStatus;
import com.restaurant.restaurant.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlCategoryModel implements CategoryModel{
    @Override
    public Category save(Category cate) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="insert into categories" +
                    "(name, createdAt, updatedAt, status)" +
                    "values " +
                    "(?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, cate.getName());
            preparedStatement.setString(2, cate.getCreatedAt().toString());
            preparedStatement.setString(3, cate.getUpdatedAt().toString());
            preparedStatement.setInt(4, cate.getStatus().getValue());
            preparedStatement.execute();
            System.out.println("Action success");
            return cate;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> findAll() {
        List<Category> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                Category obj = new Category(id, name);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                obj.setStatus(CategoryStatus.of(intStatus));
                list.add(obj);
            }
            System.out.println("Action success");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Category findbyId(int id) {
        Category cate = null;
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from categories where status = ? and id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.ACTIVE.getValue());
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                int intStatus = resultSet.getInt("status");
                cate = new Category(id, name);
                cate.setCreatedAt(createdAt);
                cate.setUpdatedAt(updatedAt);
                cate.setStatus(CategoryStatus.of(intStatus));
            }
            System.out.println("Action success");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return cate;
    }

    @Override
    public Category update(int id, Category updateCate) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  categories " +
                    "set name = ?,createdAt = ?, updatedAt = ?, status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateCate.getName());
            preparedStatement.setString(2, updateCate.getCreatedAt().toString());
            preparedStatement.setString(3, updateCate.getUpdatedAt().toString());
            preparedStatement.setInt(4, updateCate.getStatus().getValue());
            preparedStatement.setInt(5, id);
            preparedStatement.execute();
            System.out.println("Action success");
            return updateCate;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;    }

    @Override
    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update  categories " +
                    "set status = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, CategoryStatus.DELETE.getValue());
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
