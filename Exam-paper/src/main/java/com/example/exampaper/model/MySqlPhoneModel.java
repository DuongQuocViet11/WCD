package com.example.exampaper.model;

import com.example.exampaper.entity.Phone;
import com.example.exampaper.ulti.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MySqlPhoneModel implements PhoneModel{

    @Override
    public Phone save(Phone obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="insert into phones" +
                    "(brandId , name, price, description, createdAt, updatedAt)" +
                    "values " +
                    "(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, obj.getBrandId());
            preparedStatement.setString(2, obj.getName());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.setString(5, obj.getCreatedAt().toString());
            preparedStatement.setString(6, obj.getUpdatedAt().toString());
            preparedStatement.execute();
            System.out.println("Action success");
            return obj;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Phone> findAll() {
        List<Phone> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * from phones";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int brandId = resultSet.getInt("brandId");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                LocalDateTime createdAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("createdAt").toInstant(), ZoneId.systemDefault());
                LocalDateTime updatedAt =
                        LocalDateTime.ofInstant(resultSet.getTimestamp("updatedAt").toInstant(), ZoneId.systemDefault());
                Phone obj = new Phone();
                obj.setId(id);
                obj.setBrandId(brandId);
                obj.setName(name);
                obj.setPrice(price);
                obj.setDescription(description);
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
