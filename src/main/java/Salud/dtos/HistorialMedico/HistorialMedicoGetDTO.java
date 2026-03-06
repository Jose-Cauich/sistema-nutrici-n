package Salud.dtos.HistorialMedico;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class HistorialMedicoGetDTO {
    private Long idPaciente;
    private Long idNutriologa;
    private LocalDateTime fechaConsulta;
    private BigDecimal peso;
    private BigDecimal estatura;
    private BigDecimal imc;
    private String diagnostico;
    private String observaciones;
    private String alergias;
    private String alimentosRestringidos;
}