package Salud.mapper;

import Salud.dtos.User.UserPerfilGetDTO;
import Salud.dtos.User.UserPerfilPostDTO;
import Salud.entity.UserEntity;
import Salud.dtos.Patient.PatientPerfilPostDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MapperUser {

    public static UserEntity toEntity(UserPerfilPostDTO dto, PasswordEncoder encoder) {
        UserEntity user = new UserEntity();
        user.setCorreo(dto.getCorreo());
        user.setContrasena(encoder.encode(dto.getContrasena()));
        user.setNombres(dto.getNombres());
        user.setApellidoPaterno(dto.getApellidoPaterno());
        return user;
    }


    public static UserPerfilGetDTO toGetDto(UserEntity entity) {
        UserPerfilGetDTO dto = new UserPerfilGetDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setCorreo(entity.getCorreo());
        dto.setNombres(entity.getNombres());

        return dto;
    }
}