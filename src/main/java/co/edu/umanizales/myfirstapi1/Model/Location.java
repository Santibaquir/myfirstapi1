package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    private String code;
    private String name;
    private List<Location> subLocations;

    public Location(String code, String name) {
        this.code = code;
        this.name = name;
        this.subLocations = new ArrayList<>();
    }

    public void addSubLocation(Location location) {
        if (this.subLocations == null) {
            this.subLocations = new ArrayList<>();
        }
        this.subLocations.add(location);
    }
}






