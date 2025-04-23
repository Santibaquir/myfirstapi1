package co.edu.umanizales.myfirstapi1.Controller;

import co.edu.umanizales.myfirstapi1.Model.Municipio;
import co.edu.umanizales.myfirstapi1.Service.MunicipioService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Municipio>> getAll() {
        List<Municipio> municipios = municipioService.getAll();
        return ResponseEntity.ok(municipios);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Municipio>> buscarPorNombre(@PathVariable String nombre) {
        List<Municipio> resultado = municipioService.buscarPorNombre(nombre);
        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/codigo/{codigo}")
    public ResponseEntity<List<Municipio>> buscarPorCodigo(@PathVariable String codigo) {
        List<Municipio> resultado = municipioService.buscarPorCodigo(codigo);
        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/departamento/{departamento}")
    public ResponseEntity<List<Municipio>> buscarPorDepartamento(@PathVariable String departamento) {
        List<Municipio> resultado = municipioService.buscarPorDepartamento(departamento);
        if (resultado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(resultado);
    }
}