package Salud.mapper;

import Salud.dtos.HorarioNutriologa.HorarioNutriologaGetDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaPostDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaUpdateDTO;
import Salud.entity.HorarioNutriologaEntity;
import Salud.entity.NutriologasEntity;

public class HorarioNutriologaMapper {

    public static HorarioNutriologaGetDTO toDto(HorarioNutriologaEntity entity) {
        if (entity == null) return null;

        HorarioNutriologaGetDTO dto = new HorarioNutriologaGetDTO();
        dto.setIdNutriologo(entity.getNutriologa().getIdNutriologa());
        dto.setDiaSemana(entity.getDiaSemana());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());
        dto.setEsActivo(entity.getActivo());

        return dto;
    }

    public static HorarioNutriologaEntity toEntity(HorarioNutriologaPostDTO dto, NutriologasEntity nutriologa) {
        if (dto == null) return null;

        HorarioNutriologaEntity entity = new HorarioNutriologaEntity();
        entity.setNutriologa(nutriologa);
        entity.setDiaSemana(dto.getDiaSemana());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());
        entity.setActivo(true);

        return entity;
    }

    public static HorarioNutriologaEntity updateEntity(HorarioNutriologaUpdateDTO dto, HorarioNutriologaEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getDiaSemana() != null) entity.setDiaSemana(dto.getDiaSemana());
        if (dto.getHoraInicio() != null) entity.setHoraInicio(dto.getHoraInicio());
        if (dto.getHoraFin() != null) entity.setHoraFin(dto.getHoraFin());
        if (dto.getEsActivo() != null) entity.setActivo(dto.getEsActivo());

        return entity;
    }
}