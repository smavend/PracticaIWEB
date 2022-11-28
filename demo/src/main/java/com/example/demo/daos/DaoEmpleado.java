package com.example.demo.daos;

import com.example.demo.beans.Empleado;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEmpleado extends DaoBase{
    public Empleado buscarEmpleado (int idEmpleado, BigDecimal passw){
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado where idempleado = ? and dni-salario = ?";
        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idEmpleado);
            pstmt.setBigDecimal(2,passw);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    empleado = new Empleado();
                    empleado.setIdEmpleado(idEmpleado);
                    empleado.setNombre(rs.getString(2));
                    empleado.setApellido(rs.getString(3));
                    empleado.setDni(rs.getString(4));
                    empleado.setSalario(rs.getBigDecimal(5));
                    empleado.setFechaContrato(rs.getString(6));
                    empleado.setNombreUsuario(rs.getString(7));
                    empleado.setEdad(rs.getInt(8));
                    empleado.setActivo(rs.getInt(9) == 1);
                    empleado.setCine();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }
}
