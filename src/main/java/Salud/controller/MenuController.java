package Salud.controller;

import Salud.dtos.Menu.MenuGetDTO;
import Salud.dtos.Menu.MenuPostDTO;
import Salud.dtos.Menu.MenuUpdateDTO;
import Salud.service.MenuServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {

    private final MenuServicio menuServicio;

    @GetMapping
    public ResponseEntity<List<MenuGetDTO>> obtenerTodos() {
        return ResponseEntity.ok(menuServicio.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(menuServicio.obtenerPorId(id));
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<MenuGetDTO>> obtenerPorPaciente(@PathVariable Long idPaciente) {
        return ResponseEntity.ok(menuServicio.obtenerPorPaciente(idPaciente));
    }

    @PostMapping
    public ResponseEntity<MenuGetDTO> insertarMenu(@RequestBody MenuPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuServicio.insertarMenu(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarMenu(@PathVariable Long id, @RequestBody MenuUpdateDTO dto) {
        menuServicio.actualizarMenu(id, dto);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarMenu(@PathVariable Long id) {
        menuServicio.desactivarMenu(id);
        return ResponseEntity.ok().build();
    }
}