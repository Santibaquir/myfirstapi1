package co.edu.umanizales.myfirstapi1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private String saleCode;
    private String saleProductName;
    private float salePrice;
    private String saleDescription;
}
