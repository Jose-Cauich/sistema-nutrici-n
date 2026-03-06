package Salud.dtos.DetallesMenu;

import lombok.Data;

@Data
public class DetallesMenuGetDTO {
    private Long idDetalle;
    private Long idMenu;
    private Long idAlimento;
    private String diaSemana;
    private String tiempoComida;
    private String notas;
    private String porcion;

}
