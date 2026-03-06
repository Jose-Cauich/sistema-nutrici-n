package Salud.dtos.HorarioNutriologa;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioNutriologaUpdateDTO {

    private Long idHorario;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Boolean esActivo;
}

