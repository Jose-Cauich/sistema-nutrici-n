package Salud.controller;

import Salud.dtos.Cita.CitaGetDTO;
import Salud.dtos.Cita.CitaPostDTO;
import Salud.dtos.Cita.CitaPutDTO;
import Salud.service.CitaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private CitaServicio citaServicio;

    @GetMapping
    public ResponseEntity<List<CitaGetDTO>> obtenerTodos(Long id){
        return ResponseEntity.ok(citaServicio.obtenerTodos(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(citaServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<CitaGetDTO> insertarCita(@RequestBody CitaPostDTO citaPostDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(citaServicio.insertarCita(citaPostDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizar(@PathVariable Long id, @RequestBody CitaPutDTO cita){
        citaServicio.actualizarCita(id,cita);
        return  ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> eliminarCita(Long id){
        citaServicio.eliminarCita(id);
        return  ResponseEntity.ok().build();
    }






}
