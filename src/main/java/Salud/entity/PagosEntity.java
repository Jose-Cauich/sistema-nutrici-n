package Salud.entity;
import Salud.enums.EstadoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPago")
    private Long idPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    private PacientesEntity paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCita", nullable = false)
    private CitasEntity cita;

    @Column(name = "Monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "Moneda", nullable = false, columnDefinition = "text")
    private String moneda;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoPago", nullable = false)
    private EstadoPago estadoPago;

    @Column(name = "StripeReference", columnDefinition = "text")
    private String stripeReference;

    @Column(name = "FechaPago", nullable = false)
    private LocalDateTime fechaPago;

    @Column(name = "MetodoPago", nullable = false)
    private String MetodoPago;


}