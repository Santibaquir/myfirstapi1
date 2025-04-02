// Archivo: model/Persona.java
package model;

public class Persona {
    private String nombre;
    private String apellido;
    private String documento;
    private Municipio municipioResidencia;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String documento, Municipio municipioResidencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.municipioResidencia = municipioResidencia;
    }

    // Getters y setters
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Municipio getMunicipioResidencia() {
        return municipioResidencia;
    }

    public void setMunicipioResidencia(Municipio municipioResidencia) {
        this.municipioResidencia = municipioResidencia;
    }

    // Método para asignar municipio por nombre
    public boolean asignarMunicipioPorNombre(String nombreMunicipio) {
        model.Municipio municipio = model.MunicipioService.getInstance().buscarPorNombre(nombreMunicipio);
        if (municipio != null) {
            this.municipioResidencia = municipio;
            return true;
        }
        return false;
    }

    // Método para asignar municipio por código
    public boolean asignarMunicipioPorCodigo(String codigo) {
        Municipio municipio = model.MunicipioService.getInstance().buscarPorCodigo(codigo);
        if (municipio != null) {
            this.municipioResidencia = municipio;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - Documento: " + documento +
                " - Municipio: " + (municipioResidencia != null ? municipioResidencia.getNombreMunicipio() : "No asignado");
    }
}
