package Salud.mapper;
import Salud.dtos.Patient.PatientPerfilGetDTO;
import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.dtos.Patient.PatientUpdateDTO;
import Salud.entity.NutritionistEntity;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MapperPatient {

    //convertir entity a dto
    public static PatientPerfilPostDTO toDto(PatientEntity patientEntity) {

        if (patientEntity == null) {return null;}

        PatientPerfilPostDTO patientPerfilPostDTO = new PatientPerfilPostDTO();

        patientPerfilPostDTO.setNombres(patientEntity.getNombres());
        patientPerfilPostDTO.setApellidoPaterno(patientEntity.getApellidoPaterno());
        patientPerfilPostDTO.setApellidoMaterno(patientEntity.getApellidoMaterno());
        patientPerfilPostDTO.setFechaNacimiento(patientEntity.getFechaNacimiento());
        patientPerfilPostDTO.setGenero(String.valueOf(patientEntity.getGenero()));
        patientPerfilPostDTO.setDireccion(patientEntity.getDireccion());
        patientPerfilPostDTO.setTelefono(patientEntity.getTelefono());
        patientPerfilPostDTO.setCorreo(patientEntity.getCorreo());

        return patientPerfilPostDTO;
    }

    //convertir dto a entity
    public static PatientEntity toEntity(PatientPerfilPostDTO dto, UserEntity userEntity, NutritionistEntity nutritionistEntity, Gender gender) {

        if (dto == null) {return null;}

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setIdUsuario(userEntity);//se le pasa el objeto completo
        patientEntity.setNombres(dto.getNombres());
        patientEntity.setApellidoPaterno(dto.getApellidoPaterno());
        patientEntity.setApellidoMaterno(dto.getApellidoMaterno());
        patientEntity.setFechaNacimiento(dto.getFechaNacimiento());
        patientEntity.setGenero(gender);
        patientEntity.setDireccion(dto.getDireccion());
        patientEntity.setTelefono(dto.getTelefono());
        patientEntity.setCorreo(dto.getCorreo());
        patientEntity.setIdNutriologoAsignado(nutritionistEntity);

        return patientEntity;
    }




}
