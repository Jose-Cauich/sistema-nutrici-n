package Salud.controller;

import Salud.dtos.TipoCita.TipoCitaGetDTO;
import Salud.service.TipoCitasServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tipo-citas")
public class TipoCitasController {

    private final TipoCitasServicio tipoCitasServicio;

    @GetMapping
    public ResponseEntity<List<TipoCitaGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(tipoCitasServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoCitaGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoCitasServicio.obtenerPorId(id));
    }
}
