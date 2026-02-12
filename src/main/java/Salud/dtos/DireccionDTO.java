package Salud.dtos;

import lombok.Data;

@Data
public class DireccionDTO {
    private String calle;
    private String estado;
    private String colonia;
    private String codigoPostal;
    private String Municipio;
}