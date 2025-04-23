package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import co.edu.umanizales.myfirstapi1.Service.MunicipioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("/todos")
    public List<Municipio> obtenerMunicipios() {
        return municipioService.leerMunicipiosDesdeCSV();
    }
}