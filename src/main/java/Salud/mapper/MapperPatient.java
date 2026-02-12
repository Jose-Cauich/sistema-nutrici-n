package Salud.mapper;
import Salud.dtos.DireccionDTO;
import Salud.dtos.Patient.PatientPerfilGetDTO;
import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.entity.NutritionistEntity;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class MapperPatient {

    //convertir entity a dto
    public static PatientPerfilGetDTO toDtoGet(PatientEntity patientEntity) {

        if (patientEntity == null) {return null;}

        PatientPerfilGetDTO dto = new PatientPerfilGetDTO();

        dto.setNombres(patientEntity.getIdUsuario().getNombres());
        dto.setApellidoPaterno(patientEntity.getIdUsuario().getApellidoPaterno());
        dto.setApellidoMaterno(patientEntity.getIdUsuario().getApellidoMaterno());
        dto.setFechaNacimiento(patientEntity.getIdUsuario().getFechaNacimiento());
        dto.setGenero(patientEntity.getIdUsuario().getGenero());
        dto.setTelefono(patientEntity.getIdUsuario().getTelefono());
        dto.setCorreo(patientEntity.getIdUsuario().getCorreo());


        // hay que crear un nuevo obj para manejar la direccion ya que es una tabla nueva

        DireccionDTO  direccionDTO = new DireccionDTO();
        direccionDTO.setMunicipio(patientEntity.getIdUsuario().getDireccion().getMunicipio());
        direccionDTO.setColonia(patientEntity.getIdUsuario().getDireccion().getColonia());
        direccionDTO.setEstado(patientEntity.getIdUsuario().getDireccion().getEstado());
        direccionDTO.setCalle(patientEntity.getIdUsuario().getDireccion().getCalle());
        direccionDTO.setCodigoPostal(patientEntity.getIdUsuario().getDireccion().getCodigoPostal());

        //ya pasamos el obejto direccion con los nuevos datos..
        dto.setDireccion(direccionDTO);

        return dto;
    }

    public static PatientPerfilPostDTO toDtoPost(PatientEntity patientEntity) {

        if (patientEntity == null) {return null;}

        PatientPerfilPostDTO patientPerfilPostDTO = new PatientPerfilPostDTO();

        patientPerfilPostDTO.setNombres(patientEntity.getNombres());
        patientPerfilPostDTO.setApellidoPaterno(patientEntity.getApellidoPaterno());
        patientPerfilPostDTO.setApellidoMaterno(patientEntity.getApellidoMaterno());
        patientPerfilPostDTO.setFechaNacimiento(patientEntity.getFechaNacimiento());
        patientPerfilPostDTO.setGenero(patientEntity.getGenero());
        patientPerfilPostDTO.setDireccion(patientEntity.getDireccion());
        patientPerfilPostDTO.setTelefono(patientEntity.getTelefono());
        patientPerfilPostDTO.setCorreo(patientEntity.getCorreo());

        return patientPerfilPostDTO;
    }

    //convertir dto a entity
    public static PatientEntity toEntity(PatientPerfilPostDTO dto, UserEntity userEntity, NutritionistEntity nutritionistEntity, Gender gender) {

        if (dto == null) {return null;}

        PatientEntity patientEntity = new PatientEntity();

        patientEntity.setIdUsuario(userEntity);
        patientEntity.setNombres(dto.getNombres());
        patientEntity.setApellidoPaterno(dto.getApellidoPaterno());
        patientEntity.setApellidoMaterno(dto.getApellidoMaterno());
        patientEntity.setFechaNacimiento(dto.getFechaNacimiento());
        patientEntity.setGenero(gender);
        patientEntity.setDireccion(dto.getDireccion());
        patientEntity.setTelefono(dto.getTelefono());
        patientEntity.setCorreo(dto.getCorreo());
        patientEntity.setIdNutriologoAsignado(nutritionistEntity);
        patientEntity.setActivo(true);

        return patientEntity;
    }




}
