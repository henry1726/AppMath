package com.example.henrr.appmath.Entidades;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Integer id;
    private String nombre,apellidos,correo,user,password,nivel,examanes;

    public Usuario(Integer id, String nombre, String apellidos, String correo, String user, String password, String nivel, String examanes) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos=apellidos;
        this.correo=correo;
        this.user=user;
        this.password=password;
        this.nivel=nivel;
        this.examanes=examanes;
    }

    public Usuario(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswords(String password) {
        this.password = password;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getExamanes() {
        return examanes;
    }

    public void setExamanes(String examenes) {
        this.examanes = examenes;
    }
}