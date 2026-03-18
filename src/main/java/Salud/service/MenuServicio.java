package Salud.service;

import Salud.dtos.Menu.MenuGetDTO;
import Salud.dtos.Menu.MenuPostDTO;
import Salud.dtos.Menu.MenuUpdateDTO;
import Salud.entity.MenusEntity;
import Salud.entity.NutriologasEntity;
import Salud.entity.PacientesEntity;
import Salud.mapper.MenuMapper;
import Salud.repository.MenuRepository;
import Salud.repository.NutriologaRepository;
import Salud.repository.PacienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MenuServicio {

    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    public NutriologaRepository  nutriologaRepository;


    //Todos los menus
    public List<MenuGetDTO> obtenerTodos() {
        return  menuRepository.findAll().stream().map(MenuMapper::toDto).collect(Collectors.toList());
    }

    //un menu por paciente
    public MenuGetDTO obtenerPorId(Long IdMenu) {

        MenusEntity Menuentity = menuRepository.findById(IdMenu).orElseThrow(() -> new RuntimeException("Menu no encontrado"));
        return MenuMapper.toDto(Menuentity);
    }

    //todos los menus de un paciente
    public List<MenuGetDTO> obtenerPorPaciente(Long idPaciente) {
        return menuRepository.findByPaciente_IdPaciente(idPaciente).stream().map(MenuMapper::toDto).collect(Collectors.toList());
    }

    public MenuGetDTO insertarMenu(MenuPostDTO menuPostDTO) {

        PacientesEntity pacientesEntity = pacienteRepository.findById(menuPostDTO.getIdPaciente()).orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        NutriologasEntity nutriologasEntity = nutriologaRepository.findById(menuPostDTO.getIdNutriologa()).orElseThrow(() -> new RuntimeException("Nutrloga no encontrada"));
        MenusEntity menuEntity = MenuMapper.toEntity(menuPostDTO, pacientesEntity, nutriologasEntity);
        MenusEntity nuevomenu = menuRepository.save(menuEntity);
        log.info("Menú generado con éxito.");
        return MenuMapper.toDto(nuevomenu);
    }

    @Transactional
    public void actualizarMenu(Long id, MenuUpdateDTO dto) {
        MenusEntity entity = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menú no encontrado"));
        MenuMapper.updateEntity(dto, entity);
    }

    @Transactional
    public void desactivarMenu(Long id) {
        MenusEntity entity = menuRepository.findById(id).orElseThrow(() -> new RuntimeException("Menú no encontrado"));
        entity.setActivo(false);
        log.info("Menú con ID {} desactivado", id);
    }

}
