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
    public Seller getSeller() {
        Location Manizales = new Location("17001", "Manizales");
        Location Pereira = new Location("17002", "Pereira");

        Seller Juan =new Seller("1001", "Juan", "Pérez", 'M', (byte) 30,Manizales);
        Seller Maria =new Seller("1002", "María", "Gómez", 'F', (byte) 28,Manizales );
        Seller Carlos =new Seller("1003", "Carlos", "López", 'M', (byte) 35,Pereira );
        Seller Ana=new Seller("1004", "Ana", "Martínez", 'F', (byte) 26,Pereira );
        Seller Pedro =new Seller("1005", "Pedro", "Ramírez", 'M', (byte) 40,Manizales );

        return Pedro ;
    }
}
