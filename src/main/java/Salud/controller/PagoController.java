package Salud.controller;

import Salud.dtos.Pago.PagoGetDTO;
import Salud.dtos.Pago.PagoPostDTO;
import Salud.service.PagoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pagos")
public class PagoController {

    private final PagoServicio pagoServicio;

    @GetMapping("/{id}")
    public ResponseEntity<PagoGetDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pagoServicio.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<PagoGetDTO> insertarPago(@RequestBody PagoPostDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagoServicio.insertarPago(dto));
    }
}