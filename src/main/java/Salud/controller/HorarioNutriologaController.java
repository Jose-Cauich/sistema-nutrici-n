package Salud.controller;

import Salud.dtos.HorarioNutriologa.HorarioNutriologaGetDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaPostDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaUpdateDTO;
import Salud.service.HorarioNutriologaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/horarios")
public class HorarioNutriologaController {

    private final HorarioNutriologaServicio horarioServicio;

    @GetMapping
    public ResponseEntity<List<HorarioNutriologaGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(horarioServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioNutriologaGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(horarioServicio.obtenerPorId(id));
    }

    @GetMapping("/nutriologa/{idNutriologa}")
    public ResponseEntity<List<HorarioNutriologaGetDTO>> obtenerPorNutriologa(@PathVariable Long idNutriologa) {
        return ResponseEntity.ok(horarioServicio.obtenerPorNutriologa(idNutriologa));
    }

    @PostMapping
    public ResponseEntity<HorarioNutriologaGetDTO> insertarHorario(@RequestBody HorarioNutriologaPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(horarioServicio.insertarHorario(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarHorario(@PathVariable Long id, @RequestBody HorarioNutriologaUpdateDTO dto) {
        horarioServicio.actualizarHorario(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarHorario(@PathVariable Long id) {
        horarioServicio.desactivarHorario(id);
        return ResponseEntity.ok().build();
    }
}