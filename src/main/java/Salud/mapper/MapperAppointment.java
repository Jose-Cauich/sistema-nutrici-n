package Salud.mapper;

import Salud.dtos.Appointment.AppointmentGetDTO;
import Salud.dtos.Appointment.AppointmentPostDTO;
import Salud.entity.AppointmentEntity;
import Salud.entity.AppointmentTypeEntity;
import Salud.entity.NutritionistEntity;
import Salud.entity.PatientEntity;
import Salud.enums.StateAppointment;


public class MapperAppointment {

    public static AppointmentGetDTO toDto(AppointmentEntity entity) {
        if (entity == null) return null;

        AppointmentGetDTO dto = new AppointmentGetDTO();
        dto.setIdCita(entity.getIdCita());

        if (entity.getPaciente() != null) {
            //el primer get, me hace obtener el entity appointment(el objeto completo)
            // el segundo a las propiedades del entity paciente
            //setpaciente->Paciente->Idpaciente
            dto.setIdPaciente(entity.getPaciente().getIdPaciente());
        }

        //si existe el objeto nutriologo en la entity appointment
        if (entity.getNutriologo() != null) {
            dto.setIdNutriologo(entity.getNutriologo().getIdNutriologo());
        }

        if (entity.getTipoCita() != null) {
            dto.setIdTipoCita(entity.getTipoCita().getIdTipoCita());
        }

        dto.setFecha(entity.getFecha());
        dto.setHoraInicio(entity.getHoraInicio());
        dto.setHoraFin(entity.getHoraFin());

        //string por que el dto espera un string(ignoramos el enum)
        dto.setEstadoCita(String.valueOf(entity.getEstadoCita()));

        return dto;
    }

    public static AppointmentEntity toEntity(AppointmentPostDTO dto, PatientEntity patient, NutritionistEntity nutritionist, AppointmentTypeEntity tipo) {
        if (dto == null) return null;

        AppointmentEntity entity = new AppointmentEntity();

        // Asignamos las entidades reales que buscamos en el Service
        //se le pasa el objeto completo, no especificamos ID!?
        entity.setPaciente(patient);
        entity.setNutriologo(nutritionist);
        entity.setTipoCita(tipo);

        entity.setFecha(dto.getFecha());
        entity.setHoraInicio(dto.getHoraInicio());
        entity.setHoraFin(dto.getHoraFin());

        // Manejo de estado por defecto más robusto
        entity.setEstadoCita(StateAppointment.valueOf(dto.getEstadoCita() != null ? dto.getEstadoCita() : "PENDIENTE"));

        return entity;
    }
}