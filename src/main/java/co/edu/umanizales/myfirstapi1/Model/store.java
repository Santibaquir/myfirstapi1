package co.edu.umanizales.myfirstapi1.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class store{
    private String code;
    private String name;
    private String description;
    private String address;
    private String phone;
    private Location location;

}