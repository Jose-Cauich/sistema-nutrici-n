package Salud.mapper;

import Salud.dtos.Pago.PagoGetDTO;
import Salud.dtos.Pago.PagoPostDTO;
import Salud.entity.CitasEntity;
import Salud.entity.PacientesEntity;
import Salud.entity.PagosEntity;
import Salud.enums.EstadoPago;

public class PagoMapper {

    public static PagoGetDTO toDto(PagosEntity entity) {
        if (entity == null) return null;

        PagoGetDTO dto = new PagoGetDTO();
        dto.setIdPago(entity.getIdPago());
        dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        dto.setIdCita(entity.getCita().getIdCita());
        dto.setMonto(entity.getMonto());
        dto.setMoneda(entity.getMoneda());
        dto.setEstadoPago(entity.getEstadoPago().name());
        dto.setStripeReference(entity.getStripeReference());
        dto.setFechaPago(entity.getFechaPago());
        dto.setMetodoPago(entity.getMetodoPago());

        return dto;
    }

    public static PagosEntity toEntity(PagoPostDTO dto, PacientesEntity paciente, CitasEntity cita) {
        if (dto == null) return null;

        PagosEntity entity = new PagosEntity();
        entity.setPaciente(paciente);
        entity.setCita(cita);
        entity.setMonto(dto.getMonto());
        entity.setMoneda(dto.getMoneda());
        entity.setEstadoPago(EstadoPago.PENDIENTE); // al inicio es pendiente
        entity.setFechaPago(dto.getFechaPago());
        entity.setMetodoPago(dto.getMetodoPago());

        return entity;
    }

    public static PagosEntity updateEntity(PagoPostDTO dto, PagosEntity entity) {
        if (dto == null || entity == null) return entity;

        if (dto.getMonto() != null) entity.setMonto(dto.getMonto());
        if (dto.getMoneda() != null) entity.setMoneda(dto.getMoneda());
        if (dto.getEstadoPago() != null) entity.setEstadoPago(EstadoPago.valueOf(dto.getEstadoPago()));
        if (dto.getFechaPago() != null) entity.setFechaPago(dto.getFechaPago());
        if (dto.getMetodoPago() != null) entity.setMetodoPago(dto.getMetodoPago());

        return entity;
    }
}