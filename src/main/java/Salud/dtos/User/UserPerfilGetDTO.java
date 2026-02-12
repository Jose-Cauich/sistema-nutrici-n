package Salud.dtos.User;

import Salud.dtos.DireccionDTO;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserPerfilGetDTO {
    private Long idUsuario;
    private String correo;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String rolNombre;
    private LocalDateTime fechaRegistro;
    private boolean activo;
    private String avatarUrl;

    private DireccionDTO direccion;
}