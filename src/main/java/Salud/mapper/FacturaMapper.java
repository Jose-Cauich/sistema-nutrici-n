package Salud.mapper;

import Salud.dtos.Factura.FacturaGetDTO;
import Salud.dtos.Factura.FacturaPostDTO;
import Salud.entity.FacturasEntity;
import Salud.entity.PagosEntity;

public class FacturaMapper {

    public static FacturaGetDTO toDto(FacturasEntity entity) {
        if (entity == null) return null;

        FacturaGetDTO dto = new FacturaGetDTO();
        dto.setIdFactura(entity.getIdFactura());
        dto.setIdPago(entity.getPago().getIdPago()); // extrae solo el ID
        dto.setRfc(entity.getRfc());
        dto.setRazonSocial(entity.getRazonSocial());
        dto.setUsoCfdi(entity.getUsoCfdi());
        dto.setFechaEmision(entity.getFechaEmision());
        dto.setFolioFiscal(entity.getFolioFiscal());
        dto.setTotal(entity.getTotal());

        return dto;
    }

    public static FacturasEntity toEntity(FacturaPostDTO dto, PagosEntity pago) {
        if (dto == null) return null;

        FacturasEntity entity = new FacturasEntity();
        entity.setPago(pago); // objeto
        entity.setRfc(dto.getRfc());
        entity.setRazonSocial(dto.getRazonSocial());
        entity.setUsoCfdi(dto.getUsoCfdi());
        entity.setFechaEmision(dto.getFechaEmision());
        entity.setFolioFiscal(dto.getFolioFiscal());
        entity.setTotal(dto.getTotal());

        return entity;
    }
}
