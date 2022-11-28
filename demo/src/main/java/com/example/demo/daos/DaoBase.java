package com.example.demo.daos;

import java.sql.*;
public abstract class DaoBase {

    public Connection getConnection() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        String user = "root";
        String pass = "123456";
        String url = "jdbc:mysql://localhost:3306/movies";

        return DriverManager.getConnection(url, user, pass);
    }

}
