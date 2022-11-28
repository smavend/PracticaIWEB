package com.example.demo.dtos;

public class Reporte {

    private int cantEmpreadosSinJefes;
    private int cantPeli3D;
    private int cantCinesSalario9700;
    private String cineConMasCartelera;


    public int getCantEmpreadosSinJefes() {
        return cantEmpreadosSinJefes;
    }

    public void setCantEmpreadosSinJefes(int cantEmpreadosSinJefes) {
        this.cantEmpreadosSinJefes = cantEmpreadosSinJefes;
    }

    public int getCantPeli3D() {
        return cantPeli3D;
    }

    public void setCantPeli3D(int cantPeli3D) {
        this.cantPeli3D = cantPeli3D;
    }

    public int getCantCinesSalario9700() {
        return cantCinesSalario9700;
    }

    public void setCantCinesSalario9700(int cantCinesSalario9700) {
        this.cantCinesSalario9700 = cantCinesSalario9700;
    }

    public String getCineConMasCartelera() {
        return cineConMasCartelera;
    }

    public void setCineConMasCartelera(String cineConMasCartelera) {
        this.cineConMasCartelera = cineConMasCartelera;
    }
}
