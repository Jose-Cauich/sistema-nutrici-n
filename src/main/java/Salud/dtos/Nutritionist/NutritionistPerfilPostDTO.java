package Salud.dtos.Nutritionist;
import lombok.Data;
import java.time.LocalDate;

    @Data
    public class NutritionistPerfilPostDTO {
        private Long idUsuario;
        private String nombres;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String cedulaProfesional;
        private LocalDate fechaNacimiento;
        private String genero;
        private String telefono;
        private String correo;
        private String direccion;
}
