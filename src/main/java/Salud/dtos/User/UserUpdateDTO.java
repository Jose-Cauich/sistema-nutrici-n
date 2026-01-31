package Salud.dtos.User;
import lombok.Data;

@Data
public class UserUpdateDTO {
    private Long idUsuario;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private Long idRol;
    private boolean activo;
}
