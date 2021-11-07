package com.example.usingapi_androidmc.ModeloMC;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NotasMC {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("titulo")
    @Expose
    private String titulo;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    @SerializedName("fecha")
    @Expose
    private String fecha;

    @SerializedName("usuario")
    @Expose
    private String usuario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
