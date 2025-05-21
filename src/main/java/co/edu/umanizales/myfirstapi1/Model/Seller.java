package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    private String sellerID;
    private String sellerName;
    private String sellerLastName;
    private Location city;
    private String sellerGender;
    private byte sellerAge;
}
