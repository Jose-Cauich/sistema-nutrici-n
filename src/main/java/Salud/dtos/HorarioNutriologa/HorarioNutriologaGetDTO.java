package Salud.dtos.HorarioNutriologa;

import lombok.Data;
import java.time.LocalTime;

@Data
public class HorarioNutriologaGetDTO {
    private Long idNutriologo;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean esActivo;
}