package Salud.dtos.Menu;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class MenuGetDTO {
    private Long idMenu;
    private Long idPaciente;
    private Long idNutriologa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
    private String nombreMenu;
}
