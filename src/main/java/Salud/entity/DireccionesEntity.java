package Salud.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "DireccionesPacientes")
public class DireccionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDireccion")
    private Long idDireccion;

   /* @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPaciente", unique = true)
    private PacientesEntity paciente;
    */
    @Column(name = "Calle")
    private String calle;

    @Column(name = "Colonia")
    private String colonia;

    @Column(name = "CodigoPostal")
    private String codigoPostal;

    @Column(name = "Estado")
    private String estado;

    @Column(name = "Municipio")
    private String municipio;



}
