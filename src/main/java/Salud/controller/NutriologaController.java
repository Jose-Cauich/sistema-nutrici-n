package Salud.controller;

import Salud.dtos.Nutricionista.NutriologaResponseDTO;
import Salud.dtos.Nutricionista.NutriologaUpdateDTO;
import Salud.dtos.Nutricionista.NutriologalRegisterDTO;
import Salud.service.NutriologaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/nutricionistas")
public class NutriologaController {


    private final NutriologaServicio nutricionistaServicio;

    @GetMapping("/todos")
    public ResponseEntity<List<NutriologaResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(nutricionistaServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NutriologaResponseDTO> obtenerNutriologa(@PathVariable Long id) {
        return ResponseEntity.ok(nutricionistaServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<NutriologaResponseDTO> insertarNutriologa(@RequestBody NutriologalRegisterDTO nutriologalRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nutricionistaServicio.insertarNutricionista(nutriologalRegisterDTO));
    }

    //Ya se entiende que es Actualizar
    @PutMapping("/{id}")
    public ResponseEntity<Void>actualizarNutriologa(@PathVariable Long  id, @RequestBody NutriologaUpdateDTO  nutriologaUpdateDTO) {
        nutricionistaServicio.actualizarNutricionista(id, nutriologaUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void> desactivarNutriologa(@PathVariable Long  id) {
        nutricionistaServicio.desactivarNutricionista(id);
        return ResponseEntity.ok().build();
    }

}
