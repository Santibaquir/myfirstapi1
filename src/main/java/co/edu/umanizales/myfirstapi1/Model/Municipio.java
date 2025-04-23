package co.edu.umanizales.myfirstapi1.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Municipio {
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String codigoMunicipio;
    private String nombreMunicipio;
    private String tipo;
    private double longitud;
    private double latitud;

    // Constructor completo
    public Municipio(String codigoDepartamento, String nombreDepartamento, String codigoMunicipio,
                     String nombreMunicipio, String tipo, double longitud, double latitud) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.codigoMunicipio = codigoMunicipio;
        this.nombreMunicipio = nombreMunicipio;
        this.tipo = tipo;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    // Constructor con parámetros básicos
    public Municipio(String codigoDepartamento, String nombreDepartamento, String codigoMunicipio) {
        this.codigoDepartamento = codigoDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.codigoMunicipio = codigoMunicipio;
    }

    // Métodos alias para mantener compatibilidad con código existente
    public String getNombre() {
        return nombreMunicipio;
    }

    public String getCodigo() {
        return codigoMunicipio;
    }

    public String getDepartamento() {
        return nombreDepartamento;
    }
}