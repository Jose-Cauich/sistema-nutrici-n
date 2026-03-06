package Salud.dtos.Nutricionista;
import Salud.dtos.DireccionDTO;
import lombok.Data;
import java.time.LocalDate;

    @Data
    public class NutriologalRegisterDTO {

        private String nombres;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String cedulaProfesional;
        private LocalDate fechaNacimiento;
        private String genero;
        private String telefono;
        private String correo;
        private String passwordHash;
        private LocalDate fechaRegistro;
        private DireccionDTO direccion;

}
