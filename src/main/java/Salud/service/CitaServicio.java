package Salud.service;

import Salud.dtos.Cita.CitaGetDTO;
import Salud.dtos.Cita.CitaPostDTO;
import Salud.dtos.Cita.CitaPutDTO;
import Salud.entity.CitasEntity;
import Salud.entity.TipoCitasEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.enums.EstadoCita;
import Salud.mapper.CitaMapper;
import Salud.repository.CitaRepository;
import Salud.repository.TipoCitaRepository;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CitaServicio {

    @Autowired
    private CitaRepository CitaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private NutriologaRepository nutriologaRepository;
    @Autowired
    private TipoCitaRepository tipoCitaRepository;

    public List<CitaGetDTO> obtenerTodos(Long pacienteId) {
        return CitaRepository.findByPatient_IdPaciente(pacienteId).stream().map(CitaMapper::toDto).collect(Collectors.toList());
    }

    public CitaGetDTO obtenerPorId(Long citaId) {
        CitasEntity nuevaCita = CitaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        return CitaMapper.toDto(nuevaCita);
    }

    public CitaGetDTO insertarCita(CitaPostDTO dto) {

        PacientesEntity patient = pacienteRepository.findById(dto.getIdPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        NutriologasEntity nutritionist = nutriologaRepository.findById(dto.getIdNutriologa()).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        TipoCitasEntity tipo = tipoCitaRepository.findById(dto.getIdTipoCita()).orElseThrow(() -> new RuntimeException("Tipo de cita no válido"));

        CitasEntity entity = CitaMapper.toEntity(dto, patient, nutritionist, tipo);
        log.info("Cita registrada con éxito");

        return CitaMapper.toDto(CitaRepository.save(entity));

    }

    @Transactional
    public void actualizarCita(Long citaId, CitaPutDTO dto) {
        CitasEntity cita = CitaRepository.findById(citaId).orElseThrow(() -> new RuntimeException("Cita no encontrada"));
        CitaMapper.toEntity(dto, cita);
    }

}