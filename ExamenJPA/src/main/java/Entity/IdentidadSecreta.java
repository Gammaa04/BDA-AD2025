/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
public class IdentidadSecreta {
    private String nombreReal;
    private String ciudad;
    private String ocupacion;

    public IdentidadSecreta(String nombreReal, String ciudad, String ocupacion) {
        this.nombreReal = nombreReal;
        this.ciudad = ciudad;
        this.ocupacion = ocupacion;
    }

    public IdentidadSecreta() {
    }
    
    

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
    
    
    
    
}
