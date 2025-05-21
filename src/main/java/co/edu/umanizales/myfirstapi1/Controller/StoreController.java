package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Store;
import co.edu.umanizales.myfirstapi1.Service.StoreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> getAllStores() {
        return storeService.getAllStores();
    }

    @GetMapping(path = "/code/{code}")
    public Store getStoreByCode(@PathVariable String code) {
        return storeService.getStoreByCode(code);
    }

    @GetMapping(path = "/department/{departmentCode}")
    public List<Store> getStoresByDepartment(@PathVariable String departmentCode) {
        return storeService.getStoresByDepartment(departmentCode);
    }
}
