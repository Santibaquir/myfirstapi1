package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Sale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sale")

public class SaleController {

    @GetMapping
    public Sale getSales(){

        Sale sale1 = new Sale("000001", "toalla", (float)112.99, "---");

        return sale1;
    }
}