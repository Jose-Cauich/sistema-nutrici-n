package Salud.dtos.MedicalHistory;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MedicalHistoryPostDTO {
    private Long idPaciente;
    private Long idNutriologo;
    private BigDecimal peso;
    private BigDecimal estatura;
    private BigDecimal imc;
    private String diagnostico;
    private String observaciones;
    private String alergias;
    private String alimentosRestringidos;
    private String referenciaFotos;
}