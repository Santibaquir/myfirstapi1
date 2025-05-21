package co.edu.umanizales.myfirstapi1.Service;

import co.edu.umanizales.myfirstapi1.Model.Location;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {
    private List<Location> locations = new ArrayList<>();

    @PostConstruct
    public void init() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    new ClassPathResource("DIVIPOLA-_C_digos_municipios_20250408.csv").getInputStream(), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length >= 3) {
                    String departmentCode = data[0];
                    String municipalityCode = data[1];
                    String name = data[2];
                    String fullCode = departmentCode + municipalityCode;

                    Location department = getLocationByCode(departmentCode);
                    if (department == null) {
                        department = new Location(departmentCode, name);
                        locations.add(department);
                    } else {
                        department.addSubLocation(new Location(fullCode, name));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Location> getAllLocations() {
        return locations;
    }

    public Location getLocationByCode(String code) {
        for (Location dept : locations) {
            if (dept.getCode().equals(code)) return dept;
            for (Location mun : dept.getSubLocations()) {
                if (mun.getCode().equals(code)) return mun;
            }
        }
        return null;
    }

    public List<Location> getLocationByName(String name) {
        List<Location> result = new ArrayList<>();
        for (Location dept : locations) {
            if (dept.getName().toLowerCase().contains(name.toLowerCase())) result.add(dept);
            for (Location mun : dept.getSubLocations()) {
                if (mun.getName().toLowerCase().contains(name.toLowerCase())) result.add(mun);
            }
        }
        return result;
    }

    public List<Location> getLocationsByInitialLetter(String initial) {
        List<Location> result = new ArrayList<>();
        for (Location dept : locations) {
            if (dept.getName().startsWith(initial)) result.add(dept);
            for (Location mun : dept.getSubLocations()) {
                if (mun.getName().startsWith(initial)) result.add(mun);
            }
        }
        return result;
    }

    public List<Location> getLocationByDepartmentCode(String dCode) {
        for (Location dept : locations) {
            if (dept.getCode().equals(dCode)) {
                return dept.getSubLocations();
            }
        }
        return new ArrayList<>();
    }

    public List<Location> getAllDepartments() {
        return locations;
    }

    public Location getDepartmentByCode(String code) {
        for (Location dept : locations) {
            if (dept.getCode().equals(code)) {
                return dept;
            }
        }
        return null;
    }
}
