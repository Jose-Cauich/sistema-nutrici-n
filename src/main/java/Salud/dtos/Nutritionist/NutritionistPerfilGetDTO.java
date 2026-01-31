package Salud.dtos.Nutritionist;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class NutritionistPerfilGetDTO {

    private Long idNutriologo;
    private Long idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String cedulaProfesional;
    private LocalDate fechaNacimiento;
    private String genero;
    private String telefono;
    private String correo;
    private String direccion;
    private LocalDateTime fechaRegistro;
    private Boolean activo;
}
