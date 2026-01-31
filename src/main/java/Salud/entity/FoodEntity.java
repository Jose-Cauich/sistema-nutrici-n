package Salud.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "alimento")
@Data
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdAlimento")
    private Long idAlimento;

    @Column(name = "Nombre", columnDefinition = "text")
    private String nombre;

    @Column(name = "Calorias", precision = 6, scale = 2)
    private BigDecimal calorias;

    @Column(name = "Proteinas", precision = 6, scale = 2)
    private BigDecimal proteinas;

    @Column(name = "Carbohidratos", precision = 6, scale = 2)
    private BigDecimal carbohidratos;

    @Column(name = "Grasas", precision = 6, scale = 2)
    private BigDecimal grasas;

    @Column(name = "ImagenReferencia", columnDefinition = "text")
    private String imagenReferencia;

    @Column(name = "Disponible")
    private Boolean disponible = true;
}