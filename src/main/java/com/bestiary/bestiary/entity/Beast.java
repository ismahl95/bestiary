package com.bestiary.bestiary.entity;

import java.util.List;

public class Beast {
    private String Nombre;
    private String Tipo;
    private String Descripcion;
    private List<String> Ubicacion;
    private int Nivel;
    private List<String> Resistencias;
    private List<String> Debilidades;


    public Beast(String Nombre, String Tipo, String Descripcion, List<String> Ubicacion, int Nivel, List<String> Resistencias, List<String> Debilidades) {
        this.Nombre = Nombre;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Ubicacion = Ubicacion;
        this.Nivel = Nivel;
        this.Resistencias = Resistencias;
        this.Debilidades = Debilidades;
    }


    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo() {
        return this.Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return this.Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public List<String> getUbicación() {
        return this.Ubicacion;
    }

    public void setUbicación(List<String> Ubicacion) {
        this.Ubicacion = Ubicacion;
    }

    public int getNivel() {
        return this.Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }

    public List<String> getResistencias() {
        return this.Resistencias;
    }

    public void setResistencias(List<String> Resistencias) {
        this.Resistencias = Resistencias;
    }

    public List<String> getDebilidades() {
        return this.Debilidades;
    }

    public void setDebilidades(List<String> Debilidades) {
        this.Debilidades = Debilidades;
    }


}
