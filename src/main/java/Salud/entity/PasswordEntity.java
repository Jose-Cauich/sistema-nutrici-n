package Salud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credenciales")
public class PasswordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdUsuarios", nullable = false, columnDefinition = "text")
    private Long IdUsuarios;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PasswordHash", nullable = false, columnDefinition = "text")
    private Long Password;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UltimoCambio", nullable = false, columnDefinition = "text")
    private Long LastChange;




}
