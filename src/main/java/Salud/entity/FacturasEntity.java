package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "factura")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFactura")
    private Long idFactura;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPago", nullable = false)
    private PagosEntity Pago;

    @Column(name = "Rfc", length = 13)
    private String rfc;

    @Column(name = "RazonSocial", columnDefinition = "text")
    private String razonSocial;

    @Column(name = "UsoCfdi", columnDefinition = "text")
    private String usoCfdi;

    @Column(name = "FechaEmision")
    private LocalDateTime fechaEmision;

    @Column(name = "FolioFiscal", columnDefinition = "text")
    private String folioFiscal;

    @Column(name = "Total", precision = 10, scale = 2)
    private BigDecimal total;
}