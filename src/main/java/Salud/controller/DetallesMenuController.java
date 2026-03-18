package Salud.controller;

import Salud.dtos.DetallesMenu.DetallesMenuGetDTO;
import Salud.dtos.DetallesMenu.DetallesMenuPostDTO;
import Salud.dtos.DetallesMenu.DetallesMenuUpdateDTO;
import Salud.service.DetallesMenuServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/detalles-menu")
public class DetallesMenuController {

    private final DetallesMenuServicio detallesMenuServicio;

    @GetMapping
    public ResponseEntity<List<DetallesMenuGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(detallesMenuServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesMenuGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detallesMenuServicio.obtenerPorId(id));
    }

    @GetMapping("/menu/{idMenu}")
    public ResponseEntity<List<DetallesMenuGetDTO>> obtenerPorMenu(@PathVariable Long idMenu) {
        return ResponseEntity.ok(detallesMenuServicio.obtenerPorMenu(idMenu));
    }

    @PostMapping
    public ResponseEntity<DetallesMenuGetDTO> insertarDetalle(@RequestBody DetallesMenuPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detallesMenuServicio.insertarDetalle(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarDetalle(@PathVariable Long id, @RequestBody DetallesMenuUpdateDTO dto) {
        detallesMenuServicio.actualizarDetalle(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Long id) {
        detallesMenuServicio.desactivarDetalle(id);
        return ResponseEntity.ok().build();
    }
}