package Salud.controller;

import Salud.dtos.Paciente.PacienteRegisterDTO;
import Salud.dtos.Paciente.PacienteResponseDTO;
import Salud.dtos.Paciente.PacienteUpdateDTO;
import Salud.service.PacienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @GetMapping("/todos")
    public ResponseEntity<List<PacienteResponseDTO>> obtenerTodos() {
        return ResponseEntity.ok(pacienteServicio.obtenerTodos());
    }

    //Ya se entiende que es obtener
    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> obtenerPaciente(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> insertarPaciente(@RequestBody PacienteRegisterDTO pacienteRegisterDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteServicio.insertarPaciente(pacienteRegisterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPaciente(@PathVariable Long id, @RequestBody PacienteUpdateDTO pacienteUpdateDTO) {
        pacienteServicio.actualizarPaciente(id, pacienteUpdateDTO);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/desactivar/{id}")
    public ResponseEntity<Void>desactivarPaciente(@PathVariable Long id){
        pacienteServicio.desactivarPaciente(id);
        return ResponseEntity.ok().build();
    }

}
