package Salud.dtos;

import lombok.Data;

@Data
public class DireccionDTO {
    private String idDireccion;
    private String calle;
    private String colonia;
    private String codigoPostal;
    private String estado;
    private String municipio;
}