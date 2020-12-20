package com.iamseb.boundstone;

import android.media.Image;

public class Cactus {
    private String nombre;
    private int foto;
    private int likes;

    public Cactus(String nombre,int foto,int likes){
        this.nombre=nombre;
        this.foto=foto;
        this.likes=likes;
    }
    public Cactus(String nombre,int foto){
        this.nombre=nombre;
        this.foto=foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}


