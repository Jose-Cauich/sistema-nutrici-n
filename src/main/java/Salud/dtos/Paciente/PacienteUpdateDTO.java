package Salud.dtos.Paciente;

import Salud.dtos.DireccionDTO;
import lombok.Data;

@Data
public class PacienteUpdateDTO {

    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;
    private boolean estado;
    private DireccionDTO direccion;

}
