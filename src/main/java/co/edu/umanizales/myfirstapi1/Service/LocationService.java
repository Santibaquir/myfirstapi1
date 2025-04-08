package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    public List<Location> readLocationsFromCSV() {
        List<Location> locations = new ArrayList<>();

        try (InputStream is = getClass().getResourceAsStream("/DIVIPOLA-_C_digos_municipios_20250408.csv");
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { // saltar encabezado
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",", -1); // separa por coma
                if (parts.length >= 2) {
                    String code = parts[0].trim();
                    String description = parts[1].trim();
                    locations.add(new Location(code, description));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return locations;
    }
}

