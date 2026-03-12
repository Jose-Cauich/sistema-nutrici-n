package Salud.mapper;

import Salud.dtos.Menu.MenuGetDTO;
import Salud.dtos.Menu.MenuPostDTO;
import Salud.dtos.Menu.MenuUpdateDTO;
import Salud.entity.MenusEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;

public class MenuMapper {

    public static MenuGetDTO toDto(MenusEntity entity) {
        if (entity == null) return null;

        MenuGetDTO dto = new MenuGetDTO();
        dto.setIdMenu(entity.getIdMenu());
        dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        dto.setIdNutriologa(entity.getNutriologa().getIdNutriologa());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setActivo(entity.isActivo());
        dto.setNombreMenu(entity.getNombreMenu());

        return dto;
    }

    public static MenusEntity toEntity(MenuPostDTO dto, PacientesEntity paciente, NutriologasEntity nutriologa) {
        if (dto == null) return null;

        MenusEntity entity = new MenusEntity();
        entity.setPaciente(paciente);
        entity.setNutriologa(nutriologa);
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setActivo(dto.getActivo() != null ? dto.getActivo() : true);
        entity.setNombreMenu(dto.getNombreMenu());

        return entity;
    }

    public static MenusEntity updateEntity(MenuUpdateDTO dto, MenusEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getFechaInicio() != null) entity.setFechaInicio(dto.getFechaInicio());
        if (dto.getFechaFin() != null) entity.setFechaFin(dto.getFechaFin());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());
        if (dto.getNombreMenu() != null) entity.setNombreMenu(dto.getNombreMenu());

        return entity;
    }
}