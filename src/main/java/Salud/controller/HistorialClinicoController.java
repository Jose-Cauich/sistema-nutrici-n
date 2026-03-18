package Salud.controller;

import Salud.dtos.HistorialMedico.HistorialMedicoGetDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoPostDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoUpdateDTO;
import Salud.service.HistorialClinicoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/historial")
public class HistorialClinicoController {

    private final HistorialClinicoServicio historialServicio;

    @GetMapping
    public ResponseEntity<List<HistorialMedicoGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(historialServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialMedicoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(historialServicio.obtenerPorId(id));
    }

    @GetMapping("/paciente/{id}")
    public ResponseEntity<List<HistorialMedicoGetDTO>> obtenerPorPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(historialServicio.obtenerPorPaciente(id));
    }

    @PostMapping
    public ResponseEntity<HistorialMedicoGetDTO> insertarHistorial(@RequestBody HistorialMedicoPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(historialServicio.insertarHistorial(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarHistorial(@PathVariable Long id, @RequestBody HistorialMedicoUpdateDTO dto) {
        historialServicio.actualizarHistorial(id, dto);
        return ResponseEntity.ok().build();
    }
}