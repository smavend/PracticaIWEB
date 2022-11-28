package com.example.demo.daos;

import com.example.demo.beans.Cartelera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCartelera extends DaoBase{

    public ArrayList<Cartelera> obtenerCartelera(){
        ArrayList<Cartelera> cartelera = new ArrayList<>();

        String sql = "";

        try(Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){



            }

        }catch (SQLException e){
            e.getStackTrace();
        }

        return cartelera;
    }

}
