package Salud.dtos.NutritionistSchedule;

import lombok.Data;
import java.time.LocalTime;

@Data
public class NutritionistScheduleGetDTO {
    private Long idHorario;
    private Long idNutriologo;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean esActivo;
}