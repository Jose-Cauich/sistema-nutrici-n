package Salud.dtos.Payment;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PaymentGetDTO {
    private Long idPago;
    private Long idPaciente;
    private Long idCita;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private LocalDateTime fechaPago;
}
