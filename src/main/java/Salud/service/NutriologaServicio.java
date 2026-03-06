package Salud.service;

import Salud.dtos.Nutricionista.NutriologaResponseDTO;
import Salud.dtos.Nutricionista.NutriologaUpdateDTO;
import Salud.dtos.Nutricionista.NutriologalRegisterDTO;
import Salud.entity.NutriologasEntity;
import Salud.enums.Genero;
import Salud.mapper.NutricionistaMapper;
import Salud.repository.NutriologaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class NutriologaServicio {

    @Autowired
    NutriologaRepository nutriologaRepository;


    public NutriologaResponseDTO getById(Long id) {

        NutriologasEntity nutricionista= nutriologaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutriólogo no encontrado"));
        return NutricionistaMapper.toGetDto(nutricionista);
    }


    public NutriologaResponseDTO nuevoNutricionista(NutriologalRegisterDTO dto, Genero genero) {
        NutriologasEntity entity = NutricionistaMapper.toEntity(dto, genero);
        return NutricionistaMapper.toGetDto(nutriologaRepository.save(entity));
    }

    @Transactional
    public void updateNutricionista(Long id, NutriologaUpdateDTO dto) {



    }
    }

