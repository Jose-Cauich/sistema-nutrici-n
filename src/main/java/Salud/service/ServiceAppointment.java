package Salud.service;

import Salud.dtos.Appointment.AppointmentGetDTO;
import Salud.dtos.Appointment.AppointmentPostDTO;
import Salud.entity.AppointmentEntity;
import Salud.entity.AppointmentTypeEntity;
import Salud.entity.NutritionistEntity;
import Salud.entity.PatientEntity;
import Salud.mapper.MapperAppointment;
import Salud.repository.AppointmentRepository;
import Salud.repository.AppointmentTypeRepository;
import Salud.repository.NutritionistRepository;
import Salud.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ServiceAppointment {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private NutritionistRepository nutritionistRepository;
    @Autowired
    private AppointmentTypeRepository tipoCitaRepository;

    public AppointmentGetDTO createAppointment(AppointmentPostDTO dto) {

        PatientEntity patient = patientRepository.findById(dto.getIdPaciente().intValue()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        NutritionistEntity nutritionist = nutritionistRepository.findById(dto.getIdNutriologo()).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        AppointmentTypeEntity tipo = tipoCitaRepository.findById(dto.getIdTipoCita()).orElseThrow(() -> new RuntimeException("Tipo de cita no válido"));


        //creo la cita y la mapeo
        AppointmentEntity entity = MapperAppointment.toEntity(dto, patient, nutritionist, tipo);
        AppointmentEntity saved = appointmentRepository.save(entity);

        log.info("Cita creada para el día {} a las {}", dto.getFecha(), dto.getHoraInicio());
        return MapperAppointment.toDto(saved);
    }

    //todas las citas
    public List<AppointmentGetDTO> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatient_IdPaciente(patientId).stream().map(MapperAppointment::toDto).collect(Collectors.toList());
    }



}