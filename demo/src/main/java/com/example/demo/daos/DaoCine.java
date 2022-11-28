package com.example.demo.daos;

import com.example.demo.beans.Cadena;
import com.example.demo.beans.Cine;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCine extends DaoBase{
    public Cine obtenerCine (int idCine){
        Cine cine = null;
        String sql = "SELECT * FROM cine WHERE idcine = ?";
        DaoCadena daoCadena = new DaoCadena();

        try(Connection connection = this.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1,idCine);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    cine = new Cine();
                    cine.setIdCine(idCine);
                    cine.setNombre(rs.getString(2));
                    Cadena cadena = daoCadena.obtenerCadena(rs.getInt(3));
                    cine.setCadena(cadena);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cine;
    }
}
