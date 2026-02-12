package Salud.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "DireccionUsuario")
public class DirectionUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdDireccion")
    private String idDireccion;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuario")
    private String idUsuario;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Calle;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Colonia;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String CodigoPostal;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Estado;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Municipio;




}
