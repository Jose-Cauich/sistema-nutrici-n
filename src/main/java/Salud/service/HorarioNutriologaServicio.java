package Salud.service;

import Salud.dtos.HorarioNutriologa.HorarioNutriologaGetDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaPostDTO;
import Salud.dtos.HorarioNutriologa.HorarioNutriologaUpdateDTO;
import Salud.entity.HorarioNutriologaEntity;
import Salud.entity.NutriologasEntity;
import Salud.mapper.HorarioNutriologaMapper;
import Salud.repository.HorarioNutricionistaRepository;
import Salud.repository.NutriologaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HorarioNutriologaServicio {

    //Inyeccción de dependencias por Lombok
    private final HorarioNutricionistaRepository horarioRepository;
    private final NutriologaRepository nutriologaRepository;

    public List<HorarioNutriologaGetDTO> obtenerTodos() {
        return horarioRepository.findAll().stream().map(HorarioNutriologaMapper::toDto).collect(Collectors.toList());
    }

    public HorarioNutriologaGetDTO obtenerPorId(Long id) {
        HorarioNutriologaEntity horario = horarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        return HorarioNutriologaMapper.toDto(horario);
    }

    public List<HorarioNutriologaGetDTO> obtenerPorNutriologa(Long idNutriologa) {
        return horarioRepository.findByNutriologa_IdNutriologa(idNutriologa).stream().map(HorarioNutriologaMapper::toDto).collect(Collectors.toList());
    }

    public HorarioNutriologaGetDTO insertarHorario(HorarioNutriologaPostDTO dto) {
        NutriologasEntity nutriologa = nutriologaRepository.findById(dto.getIdNutriologo()).orElseThrow(() -> new RuntimeException("Nutrióloga no encontrada con ID: " + dto.getIdNutriologo()));

        HorarioNutriologaEntity nuevoHorario = HorarioNutriologaMapper.toEntity(dto, nutriologa);
        log.info("Horario médico guardado con éxito");
        return HorarioNutriologaMapper.toDto(horarioRepository.save(nuevoHorario));
    }

    @Transactional
    public void actualizarHorario(Long id, HorarioNutriologaUpdateDTO dto) {
        HorarioNutriologaEntity entity = horarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        HorarioNutriologaMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarHorario(Long id) {
        HorarioNutriologaEntity entity = horarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado con ID: " + id));
        entity.setActivo(false);
        log.info("Horario con ID {} desactivado", id);
    }
}
