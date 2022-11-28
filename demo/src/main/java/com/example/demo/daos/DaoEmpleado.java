package com.example.demo.daos;

import com.example.demo.beans.Cine;
import com.example.demo.beans.Empleado;
import com.example.demo.beans.Rol;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoEmpleado extends DaoBase{
    public Empleado buscarEmpleadoDni (String dni){
        Empleado empleado = null;
        String sql = "SELECT e.*, idrol FROM empleado e inner join rolempleado re on (e.idempleado = re.idempleado) WHERE e.dni = ?";
        DaoCine daoCine = new DaoCine();

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,dni);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setApellido(rs.getString(3));
                    empleado.setDni(dni);
                    empleado.setSalario(rs.getBigDecimal(5));
                    empleado.setFechaContrato(rs.getString(6));
                    empleado.setNombreUsuario(rs.getString(7));
                    empleado.setEdad(rs.getInt(8));
                    empleado.setActivo(rs.getInt(9) == 1);

                    Cine cine = daoCine.obtenerCine(rs.getInt(10));
                    empleado.setCine(cine);

                    Empleado jefe = this.buscarEmpleadoId(rs.getInt(11));
                    if(jefe!=null){
                        empleado.setJefe(jefe);
                    }

                    Rol rol = this.infoRol(rs.getInt(12));
                    empleado.setRol(rol);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }

    public Empleado buscarEmpleadoId (int idEmpleado){
        Empleado empleado = null;
        String sql = "SELECT e.*, idrol FROM empleado e inner join rolempleado re on (e.idempleado = re.idempleado) WHERE e.idempleado = ?";
        DaoCine daoCine = new DaoCine();

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idEmpleado);
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

                    Cine cine = daoCine.obtenerCine(rs.getInt(10));
                    empleado.setCine(cine);

                    Empleado jefe = this.buscarEmpleadoId(rs.getInt(11));
                    if(jefe!=null){
                        empleado.setJefe(jefe);
                    }

                    Rol rol = this.infoRol(rs.getInt(12));
                    empleado.setRol(rol);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleado;
    }
    public boolean validarEmpleado (String dni, double passw){
        boolean valid = false;
        String sql = "SELECT * FROM empleado where dni = ? and dni-salario = ?";

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1,dni);
            pstmt.setDouble(2,passw);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    valid = true;
                }
            }
        } catch (SQLException e) {
            return false;
        }
        return valid;
    }

    public Rol infoRol (int idRol){
        Rol rol = null;
        String sql = "SELECT * FROM rol WHERE idrol = ?";
        try(Connection connection = this.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,idRol);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    rol = new Rol();
                    rol.setIdRol(idRol);
                    rol.setNombre(rs.getString(2));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rol;
    }
}
