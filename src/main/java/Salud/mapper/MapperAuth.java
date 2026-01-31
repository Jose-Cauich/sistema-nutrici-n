package Salud.mapper;

import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MapperAuth {


    public static UserEntity toUserEntity(PatientPerfilPostDTO dto, PasswordEncoder encoder) {
        UserEntity user = new UserEntity();
        user.setCorreo(dto.getCorreo());
        user.setContrasena(encoder.encode(dto.getContrasena()));
        user.setNombres(dto.getNombres());
        user.setApellidoPaterno(dto.getApellidoPaterno());
        user.setTelefono(dto.getTelefono());
        user.setActivo(true);
        return user;
    }


    public static PatientEntity toPatientEntity(PatientPerfilPostDTO dto, UserEntity savedUser) {
        PatientEntity patient = new PatientEntity();
        patient.setIdUsuario(savedUser);
        patient.setNombres(dto.getNombres());
        patient.setApellidoPaterno(dto.getApellidoPaterno());
        patient.setApellidoMaterno(dto.getApellidoMaterno());
        patient.setCorreo(dto.getCorreo());
        patient.setTelefono(dto.getTelefono());
        patient.setDireccion(dto.getDireccion());
        patient.setFechaNacimiento(dto.getFechaNacimiento());
        patient.setGenero(Gender.valueOf(dto.getGenero().toUpperCase()));
        patient.setActivo(true);
        return patient;
    }
}