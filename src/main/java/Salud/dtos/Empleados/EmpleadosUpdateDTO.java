package Salud.dtos.Empleados;

import Salud.dtos.Direccion.DireccionDTO;
import lombok.Data;

@Data
public class EmpleadosUpdateDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private DireccionDTO direccion;
    private Boolean activo;
}
