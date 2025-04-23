
package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import com.opencsv.CSVReader;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioService {
    private List<Municipio> municipios = new ArrayList<>();

    @PostConstruct
    public void init() {
        try (CSVReader reader = new CSVReader(
                new InputStreamReader(getClass().getResourceAsStream("/DIVIPOLA-_C_digos_municipios_20250408.csv")))) {
            String[] line;
            reader.readNext(); // Saltar encabezado
            while ((line = reader.readNext()) != null) {
                if (line.length >= 3) {
                    municipios.add(new Municipio(line[0], line[1], line[2]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Municipio> getAll() {
        return municipios;
    }

    public List<Municipio> buscarPorNombre(String nombre) {
        return municipios.stream()
                .filter(m -> m.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Municipio> buscarPorCodigo(String codigo) {
        return municipios.stream()
                .filter(m -> m.getCodigo().equalsIgnoreCase(codigo))
                .collect(Collectors.toList());
    }

    public List<Municipio> buscarPorDepartamento(String departamento) {
        return municipios.stream()
                .filter(m -> m.getDepartamento().equalsIgnoreCase(departamento))
                .collect(Collectors.toList());
    }
}
