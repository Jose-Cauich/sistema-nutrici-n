package Salud.dtos.Food;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodUpdateDTO {
    private String nombre;
    private BigDecimal calorias;
    private String imagenReferencia;
    private Boolean disponible;
}