package Salud.dtos.Patient;

import lombok.Data;

@Data
public class PatientUpdateDTO {

    public String telefono;
    public String correo;
    public String direccion;
    private Boolean activo;
}
