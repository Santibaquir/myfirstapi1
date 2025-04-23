package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MunicipioService {

    public List<Municipio> leerMunicipiosDesdeCSV() {
        List<Municipio> municipios = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new FileReader("src/main/java/co/edu/umanizales/myfirstapi1/Service/DIVIPOLA-_C_digos_municipios_20250408.csv"))) {

            br.readLine(); // Saltar encabezado

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length >= 7) {
                    String codDepto = partes[0];
                    String nombreDepto = partes[1];
                    String codMun = partes[2];
                    String nombreMun = partes[3];
                    String tipo = partes[4];
                    double longitud = Double.parseDouble(partes[5]);
                    double latitud = Double.parseDouble(partes[6]);

                    municipios.add(new Municipio(codDepto, nombreDepto, codMun, nombreMun, tipo, longitud, latitud));

                    // Imprimir para verificar
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

        return municipios;
    }
}
