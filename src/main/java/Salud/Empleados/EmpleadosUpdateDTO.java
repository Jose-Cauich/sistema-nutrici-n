package Salud.Empleados;

import Salud.dtos.DireccionDTO;
import lombok.Data;

@Data
public class EmpleadosUpdateDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private Boolean activo;
    private DireccionDTO direccion;
}
