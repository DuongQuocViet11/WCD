package com.example.exampaper.model;

import com.example.exampaper.entity.Brand;
import com.example.exampaper.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlBrandModel implements BrandModel{
    @Override
    public Brand save(Brand obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="insert into brands" +
                    "(name, createdAt, updatedAt)" +
                    "values " +
                    "(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getCreatedAt().toString());
            preparedStatement.setString(3, obj.getUpdatedAt().toString());
            preparedStatement.execute();
            System.out.println("Action success");
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Brand> findAll() {
        List<Brand> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from brands";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                Brand obj = new Brand(id, name);
                obj.setCreatedAt(createdAt);
                obj.setUpdatedAt(updatedAt);
                list.add(obj);
            }
            System.out.println("Action success");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
