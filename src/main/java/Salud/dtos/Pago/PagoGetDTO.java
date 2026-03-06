package Salud.dtos.Pago;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PagoGetDTO {
    private Long idPago;
    private Long idPaciente;
    private Long idCita;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private String stripeRefence;
    private LocalDateTime fechaPago;
    private String metodoPago;
}
