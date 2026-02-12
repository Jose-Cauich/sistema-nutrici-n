package Salud.service;

import Salud.dtos.Patient.PatientPerfilGetDTO;
import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.dtos.Patient.PatientUpdateDTO;
import Salud.entity.NutritionistEntity;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import Salud.mapper.MapperPatient;
import Salud.repository.NutritionistRepository;
import Salud.repository.PatientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ServicePatient {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    NutritionistRepository nutritionistRepository;

    /*obtener paciente de la db*/
    public PatientPerfilGetDTO getPatientDTO(int id) {
        PatientEntity patient = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient no encontrado"));
        return MapperPatient.toDtoGet(patient);

    }

    /*Insertar un paciente*/
    public PatientPerfilPostDTO postPatienlDTO(PatientPerfilPostDTO dto, UserEntity userEntity, NutritionistEntity nutritionistEntity, Gender gender) {

        NutritionistEntity nutri = null;

        if (dto.getIdNutriologoAsignado() != null) {
           nutritionistRepository.findById(dto.getIdNutriologoAsignado()).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        }

        PatientEntity patient = MapperPatient.toEntity(dto, userEntity, nutritionistEntity, gender);
        return MapperPatient.toDtoPost(patientRepository.save(patient));

    }

    @Transactional
    //actualizar los datos del paciente
    public void updatePatient(int id, PatientUpdateDTO dto) {

        PatientEntity entity = patientRepository.findById(id).orElseThrow(() -> new RuntimeException("Patient no encontrado"));

        if (dto.getTelefono() != null) {
            entity.setTelefono(dto.getTelefono());
        }

        if (dto.getDireccion() != null) {
            entity.setDireccion(dto.getDireccion());
        }

        if (dto.getActivo() != null) {
            entity.setActivo(dto.getActivo());
            log.info("cambio de estado");
        }
    }


}
