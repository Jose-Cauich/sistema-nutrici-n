package Salud.service;

import Salud.dtos.Nutritionist.NutritionistPerfilGetDTO;
import Salud.dtos.Nutritionist.NutritionistUpdateDTO;
import Salud.entity.NutritionistEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import Salud.mapper.MapperNutritionist;
import Salud.repository.NutritionistRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ServiceNutritionist {

    @Autowired
    NutritionistRepository nutritionistRepository;


    public NutritionistPerfilGetDTO getById(Long id) {

        NutritionistEntity nutritionist= nutritionistRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        return MapperNutritionist.toGetDto(nutritionist);
    }


    public NutritionistPerfilGetDTO createNutritionist(NutritionistPerfilGetDTO dto, UserEntity user, Gender gender) {
        NutritionistEntity entity = MapperNutritionist.toEntity(dto, user, gender);
        return MapperNutritionist.toGetDto(nutritionistRepository.save(entity));
    }

    @Transactional
    public void updateNutritionist(Long id, NutritionistUpdateDTO dto) {

        NutritionistEntity entity = nutritionistRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));

        if (dto.getTelefono() != null) entity.setTelefono(dto.getTelefono());
        if (dto.getCorreo() != null) entity.setCorreo(dto.getCorreo());
        if (dto.getDireccion() != null) entity.setDireccion(dto.getDireccion());
        if (dto.getActivo() != null) entity.setActivo(dto.getActivo());
        }

    }

