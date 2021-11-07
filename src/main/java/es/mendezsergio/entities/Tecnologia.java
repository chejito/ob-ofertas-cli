package es.mendezsergio.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entidad que gestiona la tabla tecnologías de la base de datos
 */

public class Tecnologia {

    private Long id;

    @JsonBackReference
    private Set<Oferta> ofertas = new HashSet<>();

    // Resto de atributos
    private String nombre;

    // Constructores
    public Tecnologia() {}

    public Tecnologia(String nombre) {
        this.nombre = nombre;
    }

    public Tecnologia(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Tecnologia(Long id, Set<Oferta> ofertas, String nombre) {
        this.id = id;
        this.ofertas = ofertas;
        this.nombre = nombre;
    }

    // Setters y Getters
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

    public Set<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(Set<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

    private String getIdOfertas() {
        StringBuilder idOfertas = new StringBuilder();

        if (!ofertas.isEmpty()) {
            for(Oferta oferta : ofertas) {
                idOfertas.append(oferta.getId()).append(" ");
            }
        }


        return idOfertas.toString();
    }

    @Override
    public String toString() {
        return "Tecnologia{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tecnologia tecnologia = (Tecnologia) obj;
        return Objects.equals(nombre, tecnologia.nombre);
    }
}
