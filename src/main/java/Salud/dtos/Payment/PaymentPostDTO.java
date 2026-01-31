package Salud.dtos.Payment;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentPostDTO {
    private Long idPaciente;
    private Long idCita;
    private BigDecimal monto;
    private String moneda;
    private String estadoPago;
    private String stripeReference;
}
