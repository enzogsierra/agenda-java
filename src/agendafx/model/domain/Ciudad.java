/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendafx.model.domain;

/**
 *
 * @author enzom
 */
public class Ciudad 
{
    private int id;
    private String nombre;
    private String cpa;
    private Provincia provincia; // Manera correcta
    // private int provinciaId; // Manera incorrecta

    // Getter & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCpa() {
        return cpa;
    }

    public void setCpa(String cpa) {
        this.cpa = cpa;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    
    @Override
    public String toString() {
        return cpa + " - " + nombre + " - " + provincia;
    }
}
