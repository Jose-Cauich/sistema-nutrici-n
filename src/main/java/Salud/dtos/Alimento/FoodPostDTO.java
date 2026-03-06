package Salud.dtos.Alimento;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodPostDTO {
    private String nombre;
    private BigDecimal calorias;
    private BigDecimal proteinas;
    private BigDecimal carbohidratos;
    private BigDecimal grasas;
    private String imagenReferencia;
    private Boolean disponible;
}