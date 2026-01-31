package Salud.dtos.DetailsMenu;

import lombok.Data;

@Data
public class DetailsMenuGetDTO {
    private Long idDetalle;
    private Long idMenu;
    private Long idAlimento;
    private String nombreAlimento;
    private String diaSemana;
    private String tiempoComida;
    private String porcion;
    private String notas;
}
