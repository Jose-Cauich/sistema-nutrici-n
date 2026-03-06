package Salud.dtos.Rol;

import Salud.enums.NombreRol;
import lombok.Data;

@Data
public class RolDTO {
    private Long idRol;
    private NombreRol nombre; //ENUMs
}
