package Salud.controller;

import Salud.dtos.Alimento.AlimentoGetDTO;
import Salud.dtos.Alimento.AlimentoPostDTO;
import Salud.dtos.Alimento.AlimentoUpdateDTO;
import Salud.service.AlimentoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alimentos")
public class AlimentoController {

    private final AlimentoServicio alimentoServicio;

    @GetMapping
    public ResponseEntity<List<AlimentoGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(alimentoServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlimentoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(alimentoServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlimentoGetDTO> insertarAlimento(@RequestBody AlimentoPostDTO alimentoPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(alimentoServicio.insertarAlimento(alimentoPostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarAlimento(@PathVariable Long id, @RequestBody AlimentoUpdateDTO dto) {
        alimentoServicio.actualizarAlimento(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarAlimento(@PathVariable Long id) {
        alimentoServicio.desactivarAlimento(id);
        return ResponseEntity.ok().build();
    }
}