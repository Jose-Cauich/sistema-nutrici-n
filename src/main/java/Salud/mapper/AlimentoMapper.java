package Salud.mapper;

import Salud.dtos.Alimento.AlimentoGetDTO;
import Salud.dtos.Alimento.AlimentoPostDTO;
import Salud.dtos.Alimento.AlimentoUpdateDTO;
import Salud.entity.AlimentosEntity;

public class AlimentoMapper {

    public static AlimentoGetDTO toDto(AlimentosEntity entity) {
        if (entity == null) return null;

        AlimentoGetDTO dto = new AlimentoGetDTO();
        dto.setIdAlimento(entity.getIdAlimento());
        dto.setNombre(entity.getNombre());
        dto.setCalorias(entity.getCalorias());
        dto.setProteinas(entity.getProteinas());
        dto.setCarbohidratos(entity.getCarbohidratos());
        dto.setGrasas(entity.getGrasas());
        dto.setImagenReferencia(entity.getImagenReferencia());

        return dto;
    }

    public static AlimentosEntity toEntity(AlimentoPostDTO dto) {
        if (dto == null) return null;

        AlimentosEntity entity = new AlimentosEntity();
        entity.setNombre(dto.getNombre());
        entity.setCalorias(dto.getCalorias());
        entity.setProteinas(dto.getProteinas());
        entity.setCarbohidratos(dto.getCarbohidratos());
        entity.setGrasas(dto.getGrasas());
        entity.setImagenReferencia(dto.getImagenReferencia());
        entity.setDisponible(dto.getDisponible() != null ? dto.getDisponible() : true);

        return entity;
    }

    public static AlimentosEntity updateEntity(AlimentoUpdateDTO dto, AlimentosEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getNombre() != null) entity.setNombre(dto.getNombre());
        if (dto.getCalorias() != null) entity.setCalorias(dto.getCalorias());
        if (dto.getProteinas() != null) entity.setProteinas(dto.getProteinas());
        if (dto.getCarbohidratos() != null) entity.setCarbohidratos(dto.getCarbohidratos());
        if (dto.getGrasas() != null) entity.setGrasas(dto.getGrasas());
        if (dto.getImagenReferencia() != null) entity.setImagenReferencia(dto.getImagenReferencia());
        if (dto.getDisponible() != null) entity.setDisponible(dto.getDisponible());

        return entity;
    }
}
