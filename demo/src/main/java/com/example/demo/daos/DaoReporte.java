package com.example.demo.daos;

import com.example.demo.dtos.Reporte;

import java.sql.*;

public class DaoReporte extends DaoBase{

    public Reporte cantEmpleadosSinJefe (String numDocumento){
        Reporte reporte = null;
        String sql = "select count(em.idempleado) \n" +
                "from empleado em \n" +
                "where em.idjefe is null ";
        try (Connection connection = this.getConnection();
             Statement stmt = connection.createStatement()) {

            try(ResultSet rs = stmt.executeQuery(sql)){
                if(rs.next()){
                    reporte = new Reporte();
                    reporte.setCantEmpreadosSinJefes(rs.getInt(1));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reporte;
    }



}
