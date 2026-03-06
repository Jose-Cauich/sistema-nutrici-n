package Salud.dtos.Menu;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuPostDTO {
    private Long idPaciente;
    private Long idNutriologa;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo;
    private String nombreMenu;
}