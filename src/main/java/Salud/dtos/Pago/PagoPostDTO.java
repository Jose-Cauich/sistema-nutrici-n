package Salud.dtos.Pago;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoPostDTO {
    private String idPago;
    private Long idPaciente;
    private Long idCita;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private LocalDateTime fechaPago;
    private String metodoPago;
}
