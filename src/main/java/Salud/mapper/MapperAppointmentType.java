package Salud.mapper;

import Salud.dtos.AppointmentType.AppointmentTypeGetDTO;
import Salud.entity.AppointmentTypeEntity;

public class MapperAppointmentType {

    public static AppointmentTypeGetDTO toDto(AppointmentTypeEntity entity) {
        if (entity == null) return null;

        AppointmentTypeGetDTO dto = new AppointmentTypeGetDTO();
        dto.setIdTipo(entity.getIdTipoCita());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDuracionMinutos(entity.getDuracionMinutos());
        dto.setCosto(entity.getCosto());

        return dto;
    }

    public static AppointmentTypeEntity toEntity(AppointmentTypeGetDTO dto) {
        if (dto == null) return null;

        AppointmentTypeEntity entity = new AppointmentTypeEntity();
        entity.setIdTipoCita(dto.getIdTipo());
        entity.setDescripcion(dto.getDescripcion());
        entity.setDuracionMinutos(dto.getDuracionMinutos());
        entity.setCosto(dto.getCosto());

        return entity;
    }
}