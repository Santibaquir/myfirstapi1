package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.Seller;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SellerService {
    private final List<Seller> sellers = new ArrayList<>();
    private final LocationService locationService;

    public SellerService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new ClassPathResource("Seller_list.csv").getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 6) {
                    String id = data[0];
                    String name = data[1];
                    String lastName = data[2];
                    String cityCode = data[3];
                    String gender = data[4];
                    byte age = Byte.parseByte(data[5]);

                    Location city = locationService.getLocationByCode(cityCode);
                    sellers.add(new Seller(id, name, lastName, city, gender, age));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Seller> getAllSellers() {
        return sellers;
    }

    public Seller getSellerById(String id) {
        for (Seller s : sellers) {
            if (s.getSellerID().equals(id)) return s;
        }
        return null;
    }
}

