package Salud.dtos.MedicalHistory;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class MedicalHistoryGetDTO {
    private Long idHistorial;
    private Long idPaciente;
    private LocalDateTime fechaConsulta;
    private BigDecimal peso;
    private BigDecimal estatura;
    private BigDecimal imc;
    private String diagnostico;
    private String observaciones;
    private String alergias;
    private String alimentosRestringidos;
}