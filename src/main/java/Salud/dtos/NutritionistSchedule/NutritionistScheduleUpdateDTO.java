package Salud.dtos.NutritionistSchedule;

import lombok.Data;

import java.time.LocalTime;

@Data
public class NutritionistScheduleUpdateDTO {

    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private LocalTime hora;
    private Boolean esActivo;
}

