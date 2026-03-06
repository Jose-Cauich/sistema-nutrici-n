package Salud.service;

import Salud.dtos.Cita.CitaGetDTO;
import Salud.dtos.Cita.CitaPostDTO;
import Salud.entity.CitasEntity;
import Salud.entity.TipoCitasEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.mapper.CitaMapper;
import Salud.repository.CitaRepository;
import Salud.repository.TipoCitaRepository;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CitaServicio {

    @Autowired
    private CitaRepository CItaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private NutriologaRepository nutriologaRepository;
    @Autowired
    private TipoCitaRepository tipoCitaRepository;

    public CitaGetDTO createAppointment(CitaPostDTO dto) {

        PacientesEntity patient = pacienteRepository.findById(dto.getIdPaciente().intValue()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        NutriologasEntity nutritionist = nutriologaRepository.findById(dto.getIdNutriologo()).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        TipoCitasEntity tipo = tipoCitaRepository.findById(dto.getIdTipoCita()).orElseThrow(() -> new RuntimeException("Tipo de cita no válido"));


        //creo la cita y la mapeo
        CitasEntity entity = CitaMapper.toEntity(dto, patient, nutritionist, tipo);
        CitasEntity saved = CItaRepository.save(entity);

        log.info("Cita creada para el día {} a las {}", dto.getFecha(), dto.getHoraInicio());
        return CitaMapper.toDto(saved);
    }

    //todas las citas
    public List<CitaGetDTO> getAppointmentsByPatient(Long patientId) {
        return CItaRepository.findByPatient_IdPaciente(patientId).stream().map(CitaMapper::toDto).collect(Collectors.toList());
    }



}