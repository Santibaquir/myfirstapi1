package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.store;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/store")
public class StoreController {

    @GetMapping
    public store getStore() {
        return new store(
                "S001",
                "Tienda Principal",
                "Una tienda de productos variados",
                "Calle 123, Manizales",
                "3001234567",
                new Location("17001", "Manizales")

        );
    }
    }