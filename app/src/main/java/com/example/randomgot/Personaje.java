package com.example.randomgot;

public class Personaje {

    private String nombre;
    private Integer id;


    public Personaje(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }
}
