package Salud.dtos.DetallesMenu;

import lombok.Data;

@Data
public class DetallesMenuUpdateDTO {
    private String diaSemana;
    private String tiempoComida;
    private String porcion;
    private String notas;
}