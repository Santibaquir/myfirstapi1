package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/seller")
public class SellerController {
    @GetMapping
    public String getSeller() {
        Location manizales = new Location("17001", "Manizales");

        Seller Juan =new Seller("1001", "Juan", "Pérez", 'M', (byte) 30,manizales);
        Seller Maria =new Seller("1002", "María", "Gómez", 'F', (byte) 28,manizales );
        Seller Carlos =new Seller("1003", "Carlos", "López", 'M', (byte) 35,manizales );
        Seller Ana=new Seller("1004", "Ana", "Martínez", 'F', (byte) 26,manizales );
        Seller Pedro =new Seller("1005", "Pedro", "Ramírez", 'M', (byte) 40,manizales );

        return "" ;
    }
}
