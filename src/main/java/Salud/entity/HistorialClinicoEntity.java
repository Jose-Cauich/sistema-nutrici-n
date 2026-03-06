package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "historialclinico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialClinicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdHistorial")
    private Long idHistorial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", nullable = false)
    private PacientesEntity idPaciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdNutriologa", nullable = false)
    private NutriologasEntity idNutriologa;

    @Column(name = "Peso", precision = 5, scale = 2)
    private BigDecimal peso;

    @Column(name = "Estatura", precision = 4, scale = 2)
    private BigDecimal estatura;

    @Column(name = "Imc", precision = 5, scale = 2)
    private BigDecimal imc;

    @Column(name = "Diagnostico", columnDefinition = "text")
    private String diagnostico;

    @Column(name = "Observaciones", columnDefinition = "text")
    private String observaciones;

    @Column(name = "Alergias", columnDefinition = "text")
    private String alergias;

    @Column(name = "AlimentosRestringidos", columnDefinition = "text")
    private String alimentosRestringidos;

    @Column(name = "ReferenciaFotos", columnDefinition = "text")
    private String referenciaFotos;

    @Column(name = "ReferenciaDocumentos", columnDefinition = "text")
    private String referenciaDocumentos;

    @Column(name = "FechaConsulta")
    private LocalDateTime fechaConsulta;
}