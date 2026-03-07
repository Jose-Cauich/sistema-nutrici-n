package Salud.dtos.Nutricionista;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

@Data
public class NutriologaUpdateDTO {
    private String telefono;
    private String correo;
    private Boolean activo;
    private DireccionDTO direccion;
}
