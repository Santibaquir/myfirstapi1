package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Arrays;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    @GetMapping
    public Location getLocation() {
        return new Location("17001", "Manizales");
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return Arrays.asList(
                new Location("001", "Bogotá"),
                new Location("002", "Medellín"),
                new Location("003", "Cali")
        );
    }
}