package Salud.mapper;

import Salud.dtos.Rol.RolRequestDTO;
import Salud.dtos.Rol.RolRespondseDTO;
import Salud.entity.RolEntity;

public class RolesMapper {

    public static RolRespondseDTO toDto(RolEntity entity) {
        if (entity == null) return null;

        RolRespondseDTO dto = new RolRespondseDTO();
        dto.setNombre(entity.getNombreRol().name());
        return dto;
    }

    public static RolEntity toEntity(RolRequestDTO dto) {
        if (dto == null) return null;

        RolEntity entity = new RolEntity();
        entity.setNombreRol(dto.getNombre());
        return entity;
    }
}