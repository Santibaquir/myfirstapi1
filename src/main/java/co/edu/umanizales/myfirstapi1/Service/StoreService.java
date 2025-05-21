package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Store;
import co.edu.umanizales.myfirstapi1.repository.StoreRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Service

public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public List<Store> getStores() {
        return storeRepository.getStores();
    }

}