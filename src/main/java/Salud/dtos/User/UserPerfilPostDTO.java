package Salud.dtos.User;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserPerfilPostDTO {
    private String correo;
    private String contrasena;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String genero;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;
    private Long idRol;
}