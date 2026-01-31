package Salud.dtos.DetailsMenu;

import lombok.Data;

@Data
public class DetailsMenuPostDTO {
    private Long idMenu;
    private Long idAlimento;
    private String diaSemana;
    private String tiempoComida;
    private String porcion;
    private String notas;
}