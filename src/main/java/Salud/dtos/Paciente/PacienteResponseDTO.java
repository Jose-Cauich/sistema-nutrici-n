package Salud.dtos.Paciente;

import Salud.dtos.DireccionDTO;
import Salud.enums.Genero;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PacienteResponseDTO {

    private Long idPaciente;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String telefono;
    private String correo;
    public LocalDate fechaNacimiento;
    private LocalDateTime fechaRegistro;
    private String passwordHash;
    private boolean activo;

    //usamos objeto direccion en DTO
    private DireccionDTO direccion;
}
