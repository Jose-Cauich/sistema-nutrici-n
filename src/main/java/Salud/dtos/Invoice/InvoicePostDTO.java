package Salud.dtos.Invoice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InvoicePostDTO {
    private Long idPago;
    private String rfc;
    private String razonSocial;
    private String usoCfdi;
    private BigDecimal total;
}