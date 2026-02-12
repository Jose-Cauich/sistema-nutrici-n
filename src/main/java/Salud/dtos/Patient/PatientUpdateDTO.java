package Salud.dtos.Patient;

import Salud.dtos.DireccionDTO;
import lombok.Data;

@Data
public class PatientUpdateDTO {

    public String telefono;
    public String correo;
    private DireccionDTO direccion;
    private Boolean activo;
}
