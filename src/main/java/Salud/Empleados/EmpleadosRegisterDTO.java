package Salud.Empleados;

import Salud.dtos.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EmpleadosRegisterDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private String correo;
    private String telefono;
    private String passwordHash;
    private Integer idRol; // El ID del rol (Admin o Recepcionista)
    private LocalDate fechaRegistro;
    private DireccionDTO direccion;
}
