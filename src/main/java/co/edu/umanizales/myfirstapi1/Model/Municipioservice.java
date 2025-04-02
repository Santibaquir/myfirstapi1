// Archivo: model/MunicipioService.java
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MunicipioService {
    private static MunicipioService instance;
    private List<Municipio> municipios;
    private Map<String, Municipio> municipiosPorNombre;
    private Map<String, Municipio> municipiosPorCodigo;
    private Map<String, List<Municipio>> municipiosPorDepartamento;

    private MunicipioService() {
        municipios = new ArrayList<>();
        municipiosPorNombre = new HashMap<>();
        municipiosPorCodigo = new HashMap<>();
        municipiosPorDepartamento = new HashMap<>();
        cargarMunicipiosDesdeCSV();
    }

    public static MunicipioService getInstance() {
        if (instance == null) {
            instance = new MunicipioService();
        }
        return instance;
    }

    private void cargarMunicipiosDesdeCSV() {
        // Ruta al archivo CSV, ajusta según tu estructura de proyecto
        String csvFile = "recursos/municipios_colombia.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Saltamos la primera línea de encabezados
            br.readLine();

            while ((line = br.readLine()) != null) {
                // División basada en comas, pero teniendo en cuenta el formato específico del archivo
                String[] data = line.split(",");

                if (data.length >= 6) {
                    String codigoDepartamento = data[0].trim();
                    String nombreDepartamento = data[1].trim();
                    String codigoMunicipio = data[2].trim();
                    String nombreMunicipio = data[3].trim();
                    String latitud = data[4].trim();
                    String longitud = data[5].trim();

                    Municipio municipio = new Municipio(
                            codigoDepartamento,
                            nombreDepartamento,
                            codigoMunicipio,
                            nombreMunicipio,
                            latitud,
                            longitud
                    );

                    municipios.add(municipio);
                    municipiosPorNombre.put(nombreMunicipio.toLowerCase(), municipio);
                    municipiosPorCodigo.put(codigoMunicipio, municipio);

                    // Agregar a la lista de municipios por departamento
                    municipiosPorDepartamento.computeIfAbsent(
                            nombreDepartamento.toLowerCase(),
                            k -> new ArrayList<>()
                    ).add(municipio);
                }
            }

            System.out.println("Se cargaron " + municipios.size() + " municipios correctamente.");

        } catch (IOException e) {
            System.err.println("Error al cargar municipios desde CSV: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Municipio> getTodosMunicipios() {
        return new ArrayList<>(municipios);
    }

    public Municipio buscarPorNombre(String nombre) {
        return municipiosPorNombre.get(nombre.toLowerCase());
    }

    public Municipio buscarPorCodigo(String codigo) {
        return municipiosPorCodigo.get(codigo);
    }

    public List<Municipio> buscarPorDepartamento(String departamento) {
        List<Municipio> resultado = municipiosPorDepartamento.get(departamento.toLowerCase());
        return resultado != null ? new ArrayList<>(resultado) : new ArrayList<>();
    }

    public List<String> getListaDepartamentos() {
        List<String> departamentos = new ArrayList<>(municipiosPorDepartamento.keySet());
        return departamentos;
    }
}