package Salud.mapper;

import Salud.dtos.HistorialMedico.HistorialMedicoGetDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoPostDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoUpdateDTO;
import Salud.entity.HistorialClinicoEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;

import java.time.LocalDateTime;

public class HistorialClinicoMapper {

    public static HistorialMedicoGetDTO toDto(HistorialClinicoEntity entity) {
        if (entity == null) return null;

        HistorialMedicoGetDTO dto = new HistorialMedicoGetDTO();
        dto.setIdHistorial(entity.getIdHistorial());
        dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        dto.setIdNutriologa(entity.getNutriologa().getIdNutriologa());
        dto.setFechaConsulta(entity.getFechaConsulta());
        dto.setPeso(entity.getPeso());
        dto.setEstatura(entity.getEstatura());
        dto.setImc(entity.getImc());
        dto.setDiagnostico(entity.getDiagnostico());
        dto.setObservaciones(entity.getObservaciones());
        dto.setAlergias(entity.getAlergias());
        dto.setAlimentosRestringidos(entity.getAlimentosRestringidos());

        return dto;
    }

    public static HistorialClinicoEntity toEntity(HistorialMedicoPostDTO dto, PacientesEntity paciente, NutriologasEntity nutriologa) {
        if (dto == null) return null;

        HistorialClinicoEntity entity = new HistorialClinicoEntity();
        entity.setPaciente(paciente);
        entity.setNutriologa(nutriologa);
        entity.setPeso(dto.getPeso());
        entity.setEstatura(dto.getEstatura());
        entity.setImc(dto.getImc());
        entity.setDiagnostico(dto.getDiagnostico());
        entity.setObservaciones(dto.getObservaciones());
        entity.setAlergias(dto.getAlergias());
        entity.setAlimentosRestringidos(dto.getAlimentosRestringidos());
        entity.setReferenciaFotos(dto.getReferenciaFotos());
        entity.setReferenciaDocumentos(dto.getReferenciaDocumentos());
        entity.setFechaConsulta(LocalDateTime.now()); // se asigna automáticamente

        return entity;
    }

    public static HistorialClinicoEntity updateEntity(HistorialMedicoUpdateDTO dto, HistorialClinicoEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getPeso() != null) entity.setPeso(dto.getPeso());
        if (dto.getEstatura() != null) entity.setEstatura(dto.getEstatura());
        if (dto.getImc() != null) entity.setImc(dto.getImc());
        if (dto.getDiagnostico() != null) entity.setDiagnostico(dto.getDiagnostico());
        if (dto.getObservaciones() != null) entity.setObservaciones(dto.getObservaciones());
        if (dto.getAlergias() != null) entity.setAlergias(dto.getAlergias());
        if (dto.getAlimentosRestringidos() != null) entity.setAlimentosRestringidos(dto.getAlimentosRestringidos());
        if (dto.getReferenciaFotos() != null) entity.setReferenciaFotos(dto.getReferenciaFotos());
        if (dto.getReferenciaDocumentos() != null) entity.setReferenciaDocumentos(dto.getReferenciaDocumentos());

        return entity;
    }
}