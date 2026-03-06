package Salud.mapper;

import Salud.dtos.DireccionDTO;
import Salud.dtos.Nutricionista.NutriologaResponseDTO;
import Salud.dtos.Nutricionista.NutriologaUpdateDTO;
import Salud.dtos.Nutricionista.NutriologalRegisterDTO;
import Salud.entity.DireccionesEntity;
import Salud.entity.NutriologasEntity;
import Salud.enums.Genero;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NutricionistaMapper {

    public static NutriologaResponseDTO toGetDto(NutriologasEntity entity) {
        if (entity == null) return null;

        NutriologaResponseDTO dto = new NutriologaResponseDTO();

        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setCedulaProfesional(entity.getCedulaProfesional());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setGenero((entity.getGenero().name())); //nombre
        dto.setTelefono(entity.getTelefono());
        dto.setCorreo(entity.getCorreo());
        dto.setFechaRegistro(entity.getFechaRegistro());

        //llamada a otro mapper
        dto.setDireccion(DireccionesMapper.toDto(entity.getDireccion()));

        return dto;
    }

    public static NutriologasEntity toEntity(NutriologalRegisterDTO dto, Genero genero) {

        if (dto == null) return null;

        NutriologasEntity entity = new NutriologasEntity();

        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setCedulaProfesional(dto.getCedulaProfesional());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setGenero(genero);
        entity.setTelefono(dto.getTelefono());
        entity.setCorreo(dto.getCorreo());
        entity.setActivo(true);
        entity.setPasswordHash(dto.getPasswordHash());

        //llamada a otro mapper
        entity.setDireccion(DireccionesMapper.toEntity(dto.getDireccion()));
        return entity;
    }

    public static NutriologasEntity toEntity(NutriologaUpdateDTO dto, NutriologasEntity entity) {
        if (dto == null || entity == null) return null;

        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());

        if (dto.getDireccion() != null) {

            DireccionesEntity direccion = entity.getDireccion();
            DireccionDTO direccionDTO = dto.getDireccion();

            if (direccionDTO.getCalle() != null) direccion.setCalle(direccionDTO.getCalle());
            if (direccionDTO.getColonia() != null) direccion.setColonia(direccionDTO.getColonia());
            if (direccionDTO.getCodigoPostal()!=null) direccion.setCodigoPostal(direccionDTO.getCodigoPostal());
            if (direccionDTO.getMunicipio()!=null) direccion.setMunicipio(direccionDTO.getMunicipio());
            if (direccionDTO.getEstado() != null) direccion.setEstado(direccionDTO.getEstado());

        }

        return entity;
    }
}
