package Salud.dtos.Menu;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuGetDTO {
    private Long idMenu;
    private Long idPaciente;
    private Long idNutriologo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
}
