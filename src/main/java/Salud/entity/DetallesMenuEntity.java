package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detallemenu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallesMenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDetalle")
    private Long idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMenu", nullable = false)
    private MenusEntity idMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAlimento", nullable = false)
    private AlimentosEntity idAlimento;

    @Column(name = "DiaSemana", columnDefinition = "text")
    private String diaSemana;

    @Column(name = "TiempoComida", columnDefinition = "text")
    private String tiempoComida;

    @Column(name = "Notas", columnDefinition = "text")
    private String notas;

    @Column(name = "Porcion", columnDefinition = "text")
    private String porcion;
}