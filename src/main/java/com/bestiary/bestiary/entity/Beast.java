package com.bestiary.bestiary.entity;

import java.util.List;

public class Beast {
    private String Nombre;
    private String Tipo;
    private String Descripcion;
    private String Ubicación;
    private int Nivel;
    private List<String> Resistencias;
    private List<String> Debilidades;

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

    public String getUbicación() {
        return this.Ubicación;
    }

    public void setUbicación(String Ubicación) {
        this.Ubicación = Ubicación;
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
