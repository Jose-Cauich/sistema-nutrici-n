package Salud.mapper;

import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MapperAuth {


    public static UserEntity toUserEntity(PatientPerfilPostDTO dto) {
        UserEntity user = new UserEntity();
        user.setCorreo(dto.getCorreo());
        user.setActivo(true);
        return user;
    }


    public static PatientEntity toPatientEntity(PatientPerfilPostDTO dto, UserEntity savedUser) {
        PatientEntity patient = new PatientEntity();
        patient.setIdUsuario(savedUser);
        patient.setActivo(true);
        return patient;
    }
}