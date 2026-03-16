package Salud.service;

import Salud.dtos.DetallesMenu.DetallesMenuGetDTO;
import Salud.dtos.DetallesMenu.DetallesMenuPostDTO;
import Salud.dtos.DetallesMenu.DetallesMenuUpdateDTO;
import Salud.entity.AlimentosEntity;
import Salud.entity.DetallesMenuEntity;
import Salud.entity.MenusEntity;
import Salud.mapper.DetallesMenuMapper;
import Salud.repository.AlimentoRepository;
import Salud.repository.DetalleMenuRepository;
import Salud.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DetallesMenuServicio {

    private final DetalleMenuRepository detallesMenuRepository;
    private final MenuRepository menuRepository;
    private final AlimentoRepository alimentoRepository;

    public List<DetallesMenuGetDTO> obtenerTodos() {
        return detallesMenuRepository.findAll().stream().map(DetallesMenuMapper::toDto).collect(Collectors.toList());
    }

    public DetallesMenuGetDTO obtenerPorId(Long id) {
        DetallesMenuEntity detalle = detallesMenuRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de menú no encontrado con ID: " + id));
        return DetallesMenuMapper.toDto(detalle);
    }

    public List<DetallesMenuGetDTO> obtenerPorMenu(Long idMenu) {
        return detallesMenuRepository.findByMenu_IdMenu(idMenu).stream().map(DetallesMenuMapper::toDto).collect(Collectors.toList());
    }

    public DetallesMenuGetDTO insertarDetalle(DetallesMenuPostDTO dto) {
        MenusEntity menu = menuRepository.findById(dto.getIdMenu()).orElseThrow(() -> new RuntimeException("Menú no encontrado con ID: " + dto.getIdMenu()));
        AlimentosEntity alimento = alimentoRepository.findById(dto.getIdAlimento()).orElseThrow(() -> new RuntimeException("Alimento no encontrado con ID: " + dto.getIdAlimento()));

        DetallesMenuEntity nuevoDetalle = DetallesMenuMapper.toEntity(dto, menu, alimento);
        return DetallesMenuMapper.toDto(detallesMenuRepository.save(nuevoDetalle));
    }

    @Transactional
    public void actualizarDetalle(Long id, DetallesMenuUpdateDTO dto) {
        DetallesMenuEntity entity = detallesMenuRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de menú no encontrado con ID: " + id));
        DetallesMenuMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void DesactivarDetalle(Long id) {
        DetallesMenuEntity entity = detallesMenuRepository.findById(id).orElseThrow(() -> new RuntimeException("Detalle de menú no encontrado con ID: " + id));
        detallesMenuRepository.delete(entity);
        log.info("Detalle de menú con ID {} eliminado", id);
    }
}
