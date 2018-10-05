/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author aitor
 */

public class Ingrediente {
        
    private String id;
    private String izena;
    private String provedor;
    private String uniti;
    private String sitio;
    private String precio;
    
    public Ingrediente(String id, String izena, String provedor, String uniti, String sitio, String precio) { //derrigortuta nago, ezta? public jartzera beste pakete batetik sortuko dudalako?
        this.id = id;
        this.izena = izena;
        this.provedor = provedor;
        this.uniti = uniti;
        this.sitio = sitio;
        this.precio = precio;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIzena() {
        return izena;
    }

    public void setIzena(String izena) {
        this.izena = izena;
    }

    public String getProvedor() {
        return provedor;
    }

    public void setProvedor(String provedor) {
        this.provedor = provedor;
    }

    public String getUniti() {
        return uniti;
    }

    public void setUniti(String uniti) {
        this.uniti = uniti;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    public String toString(){
        return getId() + "," + getIzena() + "," + getProvedor() + "," + getUniti() + "," + getSitio() + "," + getPrecio();
    }
}