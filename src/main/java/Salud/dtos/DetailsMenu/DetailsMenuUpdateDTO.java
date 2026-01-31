package Salud.dtos.DetailsMenu;

import lombok.Data;

@Data
public class DetailsMenuUpdateDTO {
    private Long idAlimento;
    private String diaSemana;
    private String tiempoComida;
    private String porcion;
    private String notas;
}