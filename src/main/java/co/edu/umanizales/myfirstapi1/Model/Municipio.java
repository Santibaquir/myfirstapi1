package co.edu.umanizales.myfirstapi1.Model;

public class Municipio {
    private String codigoDepartamento;
    private String nombreDepartamento;
    private String codigoMunicipio;
    private String nombreMunicipio;
    private String tipo;
    private double longitud;
    private double latitud;

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

    // Getters
    public String getCodigoDepartamento() { return codigoDepartamento; }
    public String getNombreDepartamento() { return nombreDepartamento; }
    public String getCodigoMunicipio() { return codigoMunicipio; }
    public String getNombreMunicipio() { return nombreMunicipio; }
    public String getTipo() { return tipo; }
    public double getLongitud() { return longitud; }
    public double getLatitud() { return latitud; }
}