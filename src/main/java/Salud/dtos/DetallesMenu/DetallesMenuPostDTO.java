package Salud.dtos.DetallesMenu;

import lombok.Data;

@Data
public class DetallesMenuPostDTO {
    private Long idMenu;
    private Long idAlimento;
    private String diaSemana;
    private String tiempoComida;
    private String porcion;
    private String notas;
}