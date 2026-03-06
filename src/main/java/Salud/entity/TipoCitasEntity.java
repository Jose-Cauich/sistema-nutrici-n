package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tipocita")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCitasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdTipoCita")
    private Long idTipoCita;

    @Column(name = "Descripcion", columnDefinition = "text", nullable = false)
    private String descripcion;

    @Column(name = "DuracionMinutos", nullable = false)
    private Integer duracionMinutos;

    @Column(name = "Costo", nullable = false, precision = 10, scale = 2)
    private BigDecimal costo;
}