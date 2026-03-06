package Salud.service;

import Salud.dtos.TipoCita.TipoCitaGetDTO;
import Salud.entity.TipoCitasEntity;
import Salud.mapper.TipoCitaMapper;
import Salud.repository.TipoCitaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TipoCitasServicio {

    @Autowired
    private TipoCitaRepository repository;

    public List<TipoCitaGetDTO> getAllTypes() {
        log.info("Consultando catálogo de tipos de cita");
        return repository.findAll().stream().map(TipoCitaMapper::toDto).collect(Collectors.toList());
    }

    public TipoCitasEntity getEntityById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Tipo de cita no encontrado con ID: " + id));
    }
}