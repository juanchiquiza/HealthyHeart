package com.healthyheart.Model;

/**
 * Created by juank on 8/06/2016.
 */
public class UsuarioModel {

    private int identificacion;
    private String nombre;
    private String apellido;
    private String fecha_nac;
    private int telefono;
    private String direccion;
    private String genero;
    private int  peso;
    private String indiceMasaCorproral;
    private String raza;
    private String medicado;
    private String contrasena;
    private int talla;

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getMedicado() {

        return medicado;
    }

    public void setMedicado(String medicado) {
        this.medicado = medicado;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getIndiceMasaCorproral() {
        return indiceMasaCorproral;
    }

    public void setIndiceMasaCorproral(String indiceMasaCorproral) {
        this.indiceMasaCorproral = indiceMasaCorproral;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

}
