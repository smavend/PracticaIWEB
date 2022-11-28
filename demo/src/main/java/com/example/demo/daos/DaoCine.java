package com.example.demo.daos;

import com.example.demo.beans.Cine;

public class DaoCine extends DaoBase{
    public Cine obtenerCine (int idCine){
        Cine cine = null;
        String sql = "SELECT * FROM cine WHERE idcine = ?";
        try(Con)
    }
}
