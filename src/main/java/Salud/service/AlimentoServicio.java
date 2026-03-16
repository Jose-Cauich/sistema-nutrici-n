package Salud.service;

import Salud.dtos.Alimento.AlimentoGetDTO;
import Salud.dtos.Alimento.AlimentoPostDTO;
import Salud.dtos.Alimento.AlimentoUpdateDTO;
import Salud.entity.AlimentosEntity;
import Salud.mapper.AlimentoMapper;
import Salud.repository.AlimentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
    @Service
    @RequiredArgsConstructor

    public class AlimentoServicio {


        @Autowired
        private final AlimentoRepository alimentoRepository;

        public List<AlimentoGetDTO> obtenerTodos() {
            return alimentoRepository.findAll().stream().map(AlimentoMapper::toDto).collect(Collectors.toList());
        }

        public AlimentoGetDTO obtenerPorId(Long id) {
            AlimentosEntity alimento = alimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alimento no encontrado con ID: " + id));
            return AlimentoMapper.toDto(alimento);
        }

        public AlimentoGetDTO insertarAlimento(AlimentoPostDTO dto) {
            AlimentosEntity nuevoAlimento = AlimentoMapper.toEntity(dto);
            AlimentosEntity save = alimentoRepository.save(nuevoAlimento);
            return AlimentoMapper.toDto(save);
        }

        @Transactional
        public void actualizarAlimento(Long id, AlimentoUpdateDTO dto) {
            AlimentosEntity entity = alimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alimento no encontrado con ID: " + id));
            AlimentoMapper.updateEntity(dto, entity);
        }

        @Transactional
        public void desactivarAlimento(Long id) {
            AlimentosEntity entity = alimentoRepository.findById(id).orElseThrow(() -> new RuntimeException("Alimento no encontrado con ID: " + id));
            entity.setDisponible(false);
            log.info("Alimento con ID {} desactivado", id);
        }
    }
