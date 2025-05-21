package co.edu.umanizales.myfirstapi1.Controller;


import co.edu.umanizales.myfirstapi1.Model.Store;
import co.edu.umanizales.myfirstapi1.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //es para que el sistema espere el tipo de pedido
@RequestMapping(path = "/store") //para brindarle una ruta nombre
public class StoreController {

    @Autowired
    private StoreService storeService;



    @GetMapping
    public List<Store> getStores() {
        return storeService.getStores();
    }
}