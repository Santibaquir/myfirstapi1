package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MunicipioService {
    private List<Municipio> municipios = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            // Usar ClassPathResource para acceder al archivo en resources
            ClassPathResource resource = new ClassPathResource("DIVIPOLA-_C_digos_municipios_20250408.csv");
            Reader reader = new InputStreamReader(resource.getInputStream());

            // Configurar el parser de CSV para manejar correctamente las comillas
            CSVParser parser = new CSVParserBuilder()
                    .withSeparator(',')
                    .withQuoteChar('"')
                    .build();

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(parser)
                    .build();

            String[] line;
            csvReader.readNext(); // Saltar encabezado

            while ((line = csvReader.readNext()) != null) {
                if (line.length >= 7) {
                    try {
                        String codDepto = line[0].trim();
                        String nombreDepto = line[1].trim();
                        String codMun = line[2].trim();
                        String nombreMun = line[3].trim();
                        String tipo = line[4].trim();

                        // Procesar longitud y latitud que pueden contener comas
                        double longitud = 0.0;
                        double latitud = 0.0;

                        if (line[5] != null && !line[5].isEmpty()) {
                            String longitudStr = line[5].replace("\"", "").replace(",", ".");
                            longitud = Double.parseDouble(longitudStr);
                        }

                        if (line[6] != null && !line[6].isEmpty()) {
                            String latitudStr = line[6].replace("\"", "").replace(",", ".");
                            latitud = Double.parseDouble(latitudStr);
                        }

                        Municipio municipio = new Municipio(
                                codDepto,
                                nombreDepto,
                                codMun,
                                nombreMun,
                                tipo,
                                longitud,
                                latitud
                        );
                        municipios.add(municipio);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear valores numéricos en línea: " +
                                String.join(",", line) + " - " + e.getMessage());
                    }
                }
            }

            csvReader.close();
            System.out.println("Cargados " + municipios.size() + " municipios desde el CSV.");

        } catch (Exception e) {
            System.err.println("Error al cargar el archivo CSV: " + e.getMessage());
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