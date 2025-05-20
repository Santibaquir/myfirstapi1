package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {

    // Lista para cachear las ubicaciones después de leerlas la primera vez
    private List<Location> locationCache = null;

    public List<Location> readLocationsFromCSV() {
        // Si ya leímos las ubicaciones anteriormente, devolvemos la caché
        if (locationCache != null && !locationCache.isEmpty()) {
            return locationCache;
        }

        List<Location> locations = new ArrayList<>();

        try {
            ClassPathResource resource = new ClassPathResource("DIVIPOLA-_C_digos_municipios_20250408.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                if (firstLine) { // saltar encabezado
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",", -1);
                if (parts.length >= 7) {
                    // Código del municipio y nombre del municipio
                    String code = parts[2].trim();
                    String description = parts[3].trim();

                    // Añadir la ubicación a la lista
                    locations.add(new Location(code, description));
                }
            }
            reader.close();
            System.out.println("Cargadas " + locations.size() + " ubicaciones desde el CSV.");

            // Guardamos las ubicaciones en caché para futuras consultas
            locationCache = locations;

        } catch (Exception e) {
            System.err.println("Error al cargar ubicaciones: " + e.getMessage());
            e.printStackTrace();
            // Si ocurre un error pero ya teníamos datos en caché, los devolvemos
            if (locationCache != null && !locationCache.isEmpty()) {
                return locationCache;
            }
        }

        return locations;
    }

    public Location findLocationByCode(String code) {
        List<Location> locations = readLocationsFromCSV();
        return locations.stream()
                .filter(location -> location.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

    public List<Location> findLocationsByDescription(String description) {
        List<Location> locations = readLocationsFromCSV();
        List<Location> result = new ArrayList<>();

        for (Location location : locations) {
            if (location.getDescription().toLowerCase().contains(description.toLowerCase())) {
                result.add(location);
            }
        }

        return result;
    }


}

