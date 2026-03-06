package Salud.dtos.HistorialMedico;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HistorialMedicoUpdateDTO {

    private Long idHistorial;
    private Long idPaciente;
    private Long idNutriologa;
    private BigDecimal peso;
    private BigDecimal estatura;
    private BigDecimal imc;
    private String diagnostico;
    private String observaciones;
    private String alergias;
    private String alimentosRestringidos;
    private String referenciaFotos;
    private String referenciaDocumentos;
}
