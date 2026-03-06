package Salud.Empleados;

import Salud.dtos.DireccionDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmpleadosResponseDTO {
    private Integer idPersonal; //para operaciones
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String telefono;
    private String nombreRol;
    private LocalDateTime fechaRegistro;
    private DireccionDTO direccion;
}
