package Salud.entity;

import Salud.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPago")
    private Long idPago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    private PatientEntity idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCita", nullable = false)
    private AppointmentEntity cita;

    @Column(name = "Monto", nullable = false, precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "Moneda", nullable = false, columnDefinition = "text")
    private String moneda;

    @Enumerated(EnumType.STRING)
    @Column(name = "EstadoPago", nullable = false)
    private PaymentStatus estadoPago;

    @Column(name = "StripeReference", columnDefinition = "text")
    private String stripeReference;

    @Column(name = "FechaPago", nullable = false)
    private LocalDateTime fechaPago;
}