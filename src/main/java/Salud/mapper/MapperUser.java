package Salud.mapper;

import Salud.dtos.DireccionDTO;
import Salud.dtos.User.UserPerfilGetDTO;
import Salud.dtos.User.UserPerfilPostDTO;
import Salud.entity.DirectionUserEntity;
import Salud.entity.PasswordEntity;
import Salud.entity.RolEntity;
import Salud.entity.UserEntity;
import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.enums.Gender;
import org.springframework.security.crypto.password.PasswordEncoder;

public class MapperUser {

    public static UserEntity toEntity(UserPerfilPostDTO dto, PasswordEntity passwordEntity, RolEntity rolEntity, DirectionUserEntity directionUserEntity, Gender gender) {
        UserEntity user = new UserEntity();

        user.setNombres(dto.getNombres());
        user.setApellidoPaterno(dto.getApellidoPaterno());
        user.setApellidoMaterno(dto.getApellidoMaterno());
        user.setFechaNacimiento(dto.getFechaNacimiento());
        user.setCorreo(dto.getCorreo());
        user.setTelefono(dto.getTelefono());
        user.setActivo(true);

        //objeto, le paso el obj completo y el entity osea le entrego el objeto a hibernate
        user.setRol(rolEntity);
        user.setPassword(passwordEntity);

        //aqui es mas facil porque solo le paso el obj completo
        user.setDireccion(directionUserEntity);
        user.setGenero(gender);


        return user;
    }


    public static UserPerfilGetDTO toGetDto(UserEntity entity) {
        UserPerfilGetDTO dto = new UserPerfilGetDTO();
        dto.setIdUsuario(entity.getIdUsuario());
        dto.setCorreo(entity.getCorreo());
        dto.setNombres(entity.getNombres());
        dto.setApellidoPaterno(entity.getApellidoPaterno());
        dto.setApellidoMaterno(entity.getApellidoMaterno());


        //creo otro obj para la address ya que en el dto de user, hay un objeto
        DireccionDTO dirDto = new DireccionDTO();
        dirDto.setCalle(entity.getDireccion().getCalle());
        dirDto.setEstado(entity.getDireccion().getEstado());
        dirDto.setColonia(entity.getDireccion().getColonia());
        dirDto.setCodigoPostal(entity.getDireccion().getCodigoPostal());
        dirDto.setMunicipio(entity.getDireccion().getCodigoPostal());

        //y le paso el obejto completo al dto que voy a retornar
        dto.setDireccion(dirDto);

        dto.setRolNombre(String.valueOf(entity.getRol().getNombreRol()));

        return dto;
    }
}