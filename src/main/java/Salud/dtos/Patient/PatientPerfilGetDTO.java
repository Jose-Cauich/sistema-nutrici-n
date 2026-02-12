package Salud.dtos.Patient;

import Salud.dtos.DireccionDTO;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientPerfilGetDTO {

    private Long idPaciente;
    private Long idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    public LocalDate fechaNacimiento;
    private Enum genero;
    private String telefono;
    private String correo;
    private DireccionDTO direccion;
    private LocalDateTime fechaRegistro;
    private boolean activo;
    private Long idNutriologoAsigando;

}
