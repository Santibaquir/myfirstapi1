package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Store {
    private String storeCode;
    private String storeName;
    private Location city;
    private String address;
}