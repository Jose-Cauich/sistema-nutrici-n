package Salud.dtos.Nutritionist;

import lombok.Data;

@Data
public class NutritionistUpdateDTO {
    private String telefono;
    private String correo;
    private String direccion;
    private Boolean activo;
}
