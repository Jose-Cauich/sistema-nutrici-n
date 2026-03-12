package Salud.dtos.HorarioNutriologa;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioNutriologaPostDTO {
    private Long idNutriologo;
    private Integer diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}