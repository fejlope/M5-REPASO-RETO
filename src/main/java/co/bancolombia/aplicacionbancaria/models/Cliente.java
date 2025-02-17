package co.bancolombia.aplicacionbancaria.models;

import jakarta.persistence.*;
import java.lang.Long;

@Entity
@Table(name="cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(unique = true, length = 50)
    private String email;

    @Column(length = 15)
    private String telefono;

    @Column(length = 200)
    private String direccion;

    public Cliente() {}
    public Cliente (String nombre, String email, String telefono, String direccion){
        this.nombre = nombre;
        this.email = email ;
        this.direccion = direccion;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
