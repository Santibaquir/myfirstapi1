package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import co.edu.umanizales.myfirstapi1.Service.MunicipioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {

    private final MunicipioService municipioService;

    public MunicipioController(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("/todos")
    public List<Municipio> getAll() {
        return municipioService.getAll();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Municipio> buscarPorNombre(@PathVariable String nombre) {
        return municipioService.buscarPorNombre(nombre);
    }

    @GetMapping("/codigo/{codigo}")
    public List<Municipio> buscarPorCodigo(@PathVariable String codigo) {
        return municipioService.buscarPorCodigo(codigo);
    }

    @GetMapping("/departamento/{departamento}")
    public List<Municipio> buscarPorDepartamento(@PathVariable String departamento) {
        return municipioService.buscarPorDepartamento(departamento);
    }
}