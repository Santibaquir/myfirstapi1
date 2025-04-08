package co.edu.umanizales.myfirstapi1.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Sale implements Serializable {
    private String code;
    private String description;

}
