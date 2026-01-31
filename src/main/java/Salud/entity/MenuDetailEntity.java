package Salud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "detallemenu")
@Data
public class MenuDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDetalle")
    private Long idDetalle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdMenu", nullable = false)
    private MenuEntity idMenu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdAlimento", nullable = false)
    private FoodEntity idAlimento;

    @Column(name = "DiaSemana", columnDefinition = "text")
    private String diaSemana;

    @Column(name = "TiempoComida", columnDefinition = "text")
    private String tiempoComida;

    @Column(name = "Notas", columnDefinition = "text")
    private String notas;

    @Column(name = "Porcion", columnDefinition = "text")
    private String porcion;
}