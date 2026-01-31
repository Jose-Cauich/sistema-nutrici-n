package Salud.dtos.Menu;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MenuUpdateDTO {
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Boolean activo; // Para "desactivar" una dieta si el paciente la deja
}