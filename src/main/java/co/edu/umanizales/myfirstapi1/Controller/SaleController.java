package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.sale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")
public class SaleController {

    @GetMapping
    public sale getSale(){
        return new sale("001", "Venta de producto");
    }
}