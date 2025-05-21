package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.Store;
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
public class StoreService {
    private final List<Store> stores = new ArrayList<>();

    private final LocationService locationService;

    public StoreService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new ClassPathResource("Stores_List.csv").getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 4) {
                    String storeCode = data[0];
                    String storeName = data[1];
                    String cityCode = data[2];
                    String address = data[3];

                    Location city = locationService.getLocationByCode(cityCode);
                    Store store = new Store(storeCode, storeName, city, address);
                    stores.add(store);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Store> getAllStores() {
        return stores;
    }

    public Store getStoreByCode(String code) {
        for (Store store : stores) {
            if (store.getStoreCode().equals(code)) {
                return store;
            }
        }
        return null;
    }

    public List<Store> getStoresByDepartment(String departmentCode) {
        List<Store> result = new ArrayList<>();
        for (Store store : stores) {
            if (store.getCity() != null && store.getCity().getCode().startsWith(departmentCode)) {
                result.add(store);
            }
        }
        return result;
    }
}
