package com.example.demo.daos;

import com.example.demo.beans.Cadena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCadena extends DaoBase{
    public Cadena obtenerCadena (int idCadena){
        Cadena cadena = null;
        String sql = "SELECT * FROM cadena WHERE idcadena = ?";
        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1,idCadena);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    cadena = new Cadena();
                    cadena.setIdCadena(idCadena);
                    cadena.setRazonSocial(rs.getString(2));
                    cadena.setNombreComercial(rs.getString(3));
                    cadena.setRuc(rs.getString(4));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cadena;
    }
}
