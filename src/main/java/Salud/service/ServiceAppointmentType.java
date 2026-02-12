package Salud.service;

import Salud.dtos.AppointmentType.AppointmentTypeGetDTO;
import Salud.entity.AppointmentTypeEntity;
import Salud.mapper.MapperAppointmentType;
import Salud.repository.AppointmentTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ServiceAppointmentType {

    @Autowired
    private AppointmentTypeRepository repository;

    public List<AppointmentTypeGetDTO> getAllTypes() {
        log.info("Consultando catálogo de tipos de cita");
        return repository.findAll().stream().map(MapperAppointmentType::toDto).collect(Collectors.toList());
    }

    public AppointmentTypeEntity getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de cita no encontrado con ID: " + id));
    }
}