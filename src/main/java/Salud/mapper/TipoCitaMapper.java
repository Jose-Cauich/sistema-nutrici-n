package Salud.mapper;

import Salud.dtos.TipoCita.TipoCitaGetDTO;
import Salud.entity.TipoCitasEntity;

public class TipoCitaMapper {

    public static TipoCitaGetDTO toDto(TipoCitasEntity entity) {
        if (entity == null) return null;

        TipoCitaGetDTO dto = new TipoCitaGetDTO();
        dto.setIdTipo(entity.getIdTipoCita());
        dto.setDescripcion(entity.getDescripcion());
        dto.setDuracionMinutos(entity.getDuracionMinutos());
        dto.setCosto(entity.getCosto());

        return dto;
    }

    public static TipoCitasEntity toEntity(TipoCitaGetDTO dto) {
        if (dto == null) return null;

        TipoCitasEntity entity = new TipoCitasEntity();
        entity.setDescripcion(dto.getDescripcion());
        entity.setDuracionMinutos(dto.getDuracionMinutos());
        entity.setCosto(dto.getCosto());

        return entity;
    }
}