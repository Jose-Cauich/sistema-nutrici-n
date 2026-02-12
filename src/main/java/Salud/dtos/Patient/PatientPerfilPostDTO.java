package Salud.dtos.Patient;

import Salud.dtos.DireccionDTO;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PatientPerfilPostDTO {

    public String correo;
    public String contrasena;
    public String nombres;
    public String apellidoPaterno;
    public String apellidoMaterno;
    public LocalDate fechaNacimiento;
    private Enum genero;
    private String telefono;
    private DireccionDTO direccion;
    private Long idNutriologoAsignado;
}

