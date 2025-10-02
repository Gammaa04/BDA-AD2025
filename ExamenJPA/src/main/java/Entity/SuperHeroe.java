/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.io.Serializable;

/**
 *
 * @author Jesus Gammael Soto Escalante 248336
 */
@Entity
public class SuperHeroe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Universo universo;

    @Embedded
    private IdentidadSecreta identidadSecreta;

    @Transient
    private String fraseIconica;

    public SuperHeroe(String nombre, Universo universo, IdentidadSecreta identidadSecreta, String fraseIconica) {
        this.nombre = nombre;
        this.universo = universo;
        this.identidadSecreta = identidadSecreta;
        this.fraseIconica = fraseIconica;
    }

    public SuperHeroe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Universo getUniverso() {
        return universo;
    }

    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public IdentidadSecreta getIdentidadSecreta() {
        return identidadSecreta;
    }

    public void setIdentidadSecreta(IdentidadSecreta identidadSecreta) {
        this.identidadSecreta = identidadSecreta;
    }

    public String getFraseIconica() {
        return fraseIconica;
    }

    public void setFraseIconica(String fraseIconica) {
        this.fraseIconica = fraseIconica;
    }

}
