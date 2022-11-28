package com.example.demo.daos;

import com.example.demo.beans.Cadena;
import com.example.demo.beans.Cartelera;
import com.example.demo.beans.Cine;
import com.example.demo.beans.Pelicula;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoCartelera extends DaoBase{

    public ArrayList<Cartelera> obtenerCartelera(){
        ArrayList<Cartelera> carteleras = new ArrayList<>();

        String sql = "select cartelera.idCartelera, cadena.nombre_comercial, \n" +
                "cine.nombre, pelicula.nombre, \n" +
                "cartelera.3d, cartelera.subtitulada, \n" +
                "cartelera.doblada, cartelera.horario \n" +
                "from cartelera\n" +
                "inner join cine on (cartelera.idCine = cine.idCine) \n" +
                "inner join cadena on (cadena.idCadena = cine.idCadena) \n" +
                "inner join pelicula on (cartelera.idPelicula = pelicula.idPelicula) ";

        try(Connection conn = this.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)){

            while (rs.next()){

                Cartelera cartelera = new Cartelera();

                cartelera.setIdCartelera(rs.getInt(1));

                Cine cine = new Cine();
                Cadena cadena = new Cadena();
                cadena.setNombreComercial(rs.getString(2));
                cine.setCadena(cadena);

                cine.setNombre(rs.getString(3));
                cartelera.setCine(cine);

                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(rs.getString(4));
                cartelera.setPelicula(pelicula);

                cartelera.setTresD(rs.getInt(5));
                cartelera.setSubtitulada(rs.getInt(6));
                cartelera.setDoblada(rs.getInt(7));
                cartelera.setHorario(rs.getString(8));

                carteleras.add(cartelera);

            }

        }catch (SQLException e){
            e.getStackTrace();
        }

        return carteleras;
    }

}
