package Salud.dtos.AppointmentType;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class AppointmentTypeGetDTO {
    private Long idTipo;
    private String descripcion;
    private Integer duracionMinutos;
    private BigDecimal costo;
}
