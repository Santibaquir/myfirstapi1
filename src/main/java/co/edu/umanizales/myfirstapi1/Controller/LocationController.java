package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Location;
import co.edu.umanizales.myfirstapi1.Service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @GetMapping(path = "/code/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locationService.getLocationByCode(code);
    }

    @GetMapping(path = "/name/{name}")
    public List<Location> getLocationsByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping(path = "/initial/{letter}")
    public List<Location> getLocationsByInitialLetter(@PathVariable String letter) {
        return locationService.getLocationsByInitialLetter(letter);
    }

    @GetMapping(path = "/department_code/{dCode}")
    public List<Location> getLocationsByDepartmentCode(@PathVariable String dCode) {
        return locationService.getLocationByDepartmentCode(dCode);
    }

    @GetMapping(path = "/departments")
    public List<Location> getAllDepartments() {
        return locationService.getAllDepartments();
    }

    @GetMapping(path = "/department/{departmentCode}")
    public Location getDepartment(@PathVariable String departmentCode) {
        return locationService.getDepartmentByCode(departmentCode);
    }
}



