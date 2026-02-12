package Salud.mapper;

import Salud.dtos.Nutritionist.NutritionistPerfilGetDTO;
import Salud.entity.NutritionistEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapperNutritionist {

    public static NutritionistPerfilGetDTO toGetDto(NutritionistEntity entity) {
        if (entity == null) return null;

        NutritionistPerfilGetDTO dto = new NutritionistPerfilGetDTO();
        dto.setIdNutriologo(entity.getIdNutriologo());
        dto.setIdUsuario(entity.getIdNutriologo() != null ? entity.getIdUsuario().getIdUsuario() : null);
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());
        dto.setCedulaProfesional(entity.getCedulaProfesional());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setGenero(String.valueOf(entity.getGenero()));
        dto.setTelefono(entity.getTelefono());
        dto.setCorreo(entity.getCorreo());
        dto.setDireccion(entity.getDireccion());
        dto.setFechaRegistro(entity.getFechaRegistro());
        dto.setActivo(entity.getActivo());

        return dto;
    }

    public static NutritionistEntity toEntity(NutritionistPerfilGetDTO dto, UserEntity userEntity, Gender gender) {

        if (dto == null) return null;

        NutritionistEntity entity = new NutritionistEntity();

        entity.setIdUsuario(userEntity);

        entity.setNombres(dto.getNombres());
        entity.setApellidoPaterno(dto.getApellidoPaterno());
        entity.setApellidoMaterno(dto.getApellidoMaterno());
        entity.setCedulaProfesional(dto.getCedulaProfesional());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        entity.setGenero(gender);
        entity.setTelefono(dto.getTelefono());
        entity.setCorreo(dto.getCorreo());
        entity.setDireccion(dto.getDireccion());
        entity.setActivo(true);

        return entity;
    }
}
