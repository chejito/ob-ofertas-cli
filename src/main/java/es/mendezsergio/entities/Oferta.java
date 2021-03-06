package es.mendezsergio.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad que gestiona la tabla ofertas de la base de datos
 */

  public class Oferta {

    private Long id;

    private Set<Tecnologia> tecnologias = new HashSet<>();

    // Resto de atributos
    private String nombre;
    private String empresa;
    private String descripcion;
    private Integer numeroVacantes;
    private String localidad;
    private Integer salarioMinimo;
    private Integer salarioMaximo;
    private String modalidad;
    private Integer anyosExperiencia;
    private String titulacion;
    private String categoria;
    private String tipoContrato;
    private Date fechaPublicacion;
    private Boolean estadoProceso;
    private String urlImagen;

    // Constructores
    public Oferta() {}



    public Oferta(Long id, Set<Tecnologia> tecnologias, String nombre, String empresa, String descripcion, Integer numeroVacantes,
                  String localidad, Integer salarioMinimo, Integer salarioMaximo, String modalidad,
                  Integer anyosExperiencia, String titulacion, String categoria, String tipoContrato,
                  Date fechaPublicacion, Boolean estadoProceso, String urlImagen) {

        this.id = id;
        this.tecnologias = tecnologias;
        this.nombre = nombre;
        this.empresa = empresa;
        this.descripcion = descripcion;
        this.numeroVacantes = numeroVacantes;
        this.localidad = localidad;
        this.salarioMinimo = salarioMinimo;
        this.salarioMaximo = salarioMaximo;
        this.modalidad = modalidad;
        this.anyosExperiencia = anyosExperiencia;
        this.titulacion = titulacion;
        this.categoria = categoria;
        this.tipoContrato = tipoContrato;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoProceso = estadoProceso;
        this.urlImagen = urlImagen;
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

    public Set<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(Set<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumeroVacantes() {
        return numeroVacantes;
    }

    public void setNumeroVacantes(Integer numeroVacantes) {
        this.numeroVacantes = numeroVacantes;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getSalarioMinimo() {
        return salarioMinimo;
    }

    public void setSalarioMinimo(Integer salarioMinimo) {
        this.salarioMinimo = salarioMinimo;
    }

    public Integer getSalarioMaximo() {
        return salarioMaximo;
    }

    public void setSalarioMaximo(Integer salarioMaximo) {
        this.salarioMaximo = salarioMaximo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Integer getAnyosExperiencia() {
        return anyosExperiencia;
    }

    public void setAnyosExperiencia(Integer anyosExperiencia) {
        this.anyosExperiencia = anyosExperiencia;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getEstadoProceso() {
        return estadoProceso;
    }

    public void setEstadoProceso(Boolean estadoProceso) {
        this.estadoProceso = estadoProceso;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", tecnologias=" + tecnologias +
                ", empresa='" + empresa + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", numeroVacantes=" + numeroVacantes +
                ", localidad='" + localidad + '\'' +
                ", salarioMinimo=" + salarioMinimo +
                ", salarioMaximo=" + salarioMaximo +
                ", modalidad='" + modalidad + '\'' +
                ", anyosExperiencia=" + anyosExperiencia +
                ", titulacion='" + titulacion + '\'' +
                ", categoria=" + categoria +
                ", tipoContrato='" + tipoContrato + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                ", estadoProceso=" + estadoProceso +
                ", urlImagen='" + urlImagen + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Oferta)) return false;
        return id != null && id.equals(((Oferta) obj).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}