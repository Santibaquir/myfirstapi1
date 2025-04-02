// Archivo: model/Municipio.java
package model;

public class Municipio {
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String codigoMunicipio;
    private String nombreMunicipio;
    private String latitud;
    private String longitud;

    public Municipio(String codigoDepartamento, String nombreDepartamento,
                     String codigoMunicipio, String nombreMunicipio,
                     String latitud, String longitud) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.codigoMunicipio = codigoMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    // Getters
    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public String getNombreMunicipio() {
        return nombreMunicipio;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    @Override
    public String toString() {
        return nombreMunicipio + " (" + nombreDepartamento + ") - Código: " + codigoMunicipio;
    }
}