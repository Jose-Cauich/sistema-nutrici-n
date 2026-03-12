package Salud.mapper;

import Salud.dtos.DetallesMenu.DetallesMenuGetDTO;
import Salud.dtos.DetallesMenu.DetallesMenuPostDTO;
import Salud.dtos.DetallesMenu.DetallesMenuUpdateDTO;
import Salud.entity.AlimentosEntity;
import Salud.entity.DetallesMenuEntity;
import Salud.entity.MenusEntity;

public class DetallesMenuMapper {

    public static DetallesMenuGetDTO toDto(DetallesMenuEntity entity) {
        if (entity == null) return null;

        DetallesMenuGetDTO dto = new DetallesMenuGetDTO();
        dto.setIdDetalle(entity.getIdDetalle());
        dto.setIdMenu(entity.getMenu().getIdMenu());
        dto.setIdAlimento(entity.getAlimento().getIdAlimento());
        dto.setDiaSemana(entity.getDiaSemana());
        dto.setTiempoComida(entity.getTiempoComida());
        dto.setNotas(entity.getNotas());
        dto.setPorcion(entity.getPorcion());

        return dto;
    }

    public static DetallesMenuEntity toEntity(DetallesMenuPostDTO dto, MenusEntity menu, AlimentosEntity alimento) {
        if (dto == null) return null;

        DetallesMenuEntity entity = new DetallesMenuEntity();
        entity.setMenu(menu);
        entity.setAlimento(alimento);
        entity.setDiaSemana(dto.getDiaSemana());
        entity.setTiempoComida(dto.getTiempoComida());
        entity.setPorcion(dto.getPorcion());
        entity.setNotas(dto.getNotas());

        return entity;
    }

    public static DetallesMenuEntity updateEntity(DetallesMenuUpdateDTO dto, DetallesMenuEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getDiaSemana() != null) entity.setDiaSemana(dto.getDiaSemana());
        if (dto.getTiempoComida() != null) entity.setTiempoComida(dto.getTiempoComida());
        if (dto.getPorcion() != null) entity.setPorcion(dto.getPorcion());
        if (dto.getNotas() != null) entity.setNotas(dto.getNotas());

        return entity;
    }
}