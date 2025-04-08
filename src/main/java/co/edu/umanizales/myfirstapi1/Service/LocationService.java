package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    public List<Location> readLocationsFromCSV() {
        List<Location> locations = new ArrayList<>()
                ;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/co/edu/umanizales/myfirstapi1/Service/DIVIPOLA-_C_digos_municipios_20250408.csv"))
            ;)
        {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { // saltar encabezado
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length >= 7) {
                    String codDepto = parts[0].trim();
                    String nombreDepto = parts[1].trim();
                    String codMun = parts[2].trim();
                    String nombreMun = parts[3].trim();
                    String tipo = parts[4].trim();
                    String longitud = parts[5].replace("\"", "").trim();
                    String latitud = parts[6].replace("\"", "").trim();

                    System.out.println("Código Depto: " + codDepto +
                            " - Nombre Depto: " + nombreDepto +
                            " - Código Mun: " + codMun +
                            " - Nombre Mun: " + nombreMun +
                            " - Tipo: " + tipo +
                            " - Longitud: " + longitud +
                            " - Latitud: " + latitud);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }
}

