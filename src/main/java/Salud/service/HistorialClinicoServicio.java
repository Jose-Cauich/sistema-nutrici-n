package Salud.service;

import Salud.dtos.HistorialMedico.HistorialMedicoGetDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoPostDTO;
import Salud.dtos.HistorialMedico.HistorialMedicoUpdateDTO;
import Salud.entity.HistorialClinicoEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.mapper.HistorialClinicoMapper;
import Salud.repository.HistorialClinicoRepository;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistorialClinicoServicio {

    //Inyeccción de dependencias por Lombok
    private final HistorialClinicoRepository historialRepository;
    private final PacienteRepository pacienteRepository;
    private final NutriologaRepository nutriologaRepository;

    public List<HistorialMedicoGetDTO> obtenerTodos() {
        return historialRepository.findAll().stream().map(HistorialClinicoMapper::toDto).collect(Collectors.toList());
    }

    public HistorialMedicoGetDTO obtenerPorId(Long id) {
        HistorialClinicoEntity historial = historialRepository.findById(id).orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
        return HistorialClinicoMapper.toDto(historial);
    }

    public List<HistorialMedicoGetDTO> obtenerPorPaciente(Long idPaciente) {
        return historialRepository.findByPaciente_IdPaciente(idPaciente).stream().map(HistorialClinicoMapper::toDto).collect(Collectors.toList());
    }

    public HistorialMedicoGetDTO insertarHistorial(HistorialMedicoPostDTO dto) {
        PacientesEntity paciente = pacienteRepository.findById(dto.getIdPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + dto.getIdPaciente()));
        NutriologasEntity nutriologa = nutriologaRepository.findById(dto.getIdNutriologa()).orElseThrow(() -> new RuntimeException("Nutrióloga no encontrada con ID: " + dto.getIdNutriologa()));

        HistorialClinicoEntity nuevoHistorial = HistorialClinicoMapper.toEntity(dto, paciente, nutriologa);
        log.info("Historial médico generado con éxito");
        return HistorialClinicoMapper.toDto(historialRepository.save(nuevoHistorial));
    }

    @Transactional
    public void actualizarHistorial(Long id, HistorialMedicoUpdateDTO dto) {
        HistorialClinicoEntity entity = historialRepository.findById(id).orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
        HistorialClinicoMapper.updateEntity(dto, entity);
    }
}