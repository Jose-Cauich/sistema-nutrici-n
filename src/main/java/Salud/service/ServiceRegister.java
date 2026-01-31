package Salud.service;

import Salud.dtos.Patient.PatientPerfilPostDTO;
import Salud.dtos.User.UserPerfilGetDTO;
import Salud.entity.PatientEntity;
import Salud.entity.UserEntity;
import Salud.enums.Gender;
import Salud.mapper.MapperUser;
import Salud.repository.NutritionistRepository;
import Salud.repository.PatientRepository;
import Salud.repository.RoleRepository;
import Salud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceRegister {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private NutritionistRepository nutritionistRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public UserPerfilGetDTO registerPatient(PatientPerfilPostDTO dto, Gender genero) {

        UserEntity user = new UserEntity();

        user.setCorreo(dto.getCorreo());
        user.setContrasena(passwordEncoder.encode(dto.getContrasena()));
        user.setNombres(dto.getNombres());
        user.setActivo(true);
        user.setApellidoPaterno(dto.getApellidoPaterno());
        user.setTelefono(dto.getTelefono());
        user.setRol(roleRepository.findByNombre("PACIENTE").orElseThrow(() -> new RuntimeException("Rol no encontrado")));

        //save
        UserEntity savedUser = userRepository.save(user);

        /**
         *
         * mapper paciente
         *
         * */


        //paciente
        PatientEntity patient = new PatientEntity();

        patient.setIdUsuario(savedUser);
        patient.setNombres(dto.getNombres());
        patient.setApellidoPaterno(dto.getApellidoPaterno());
        patient.setApellidoMaterno(dto.getApellidoMaterno());
        patient.setCorreo(dto.getCorreo());
        patient.setTelefono(dto.getTelefono());
        patient.setDireccion(dto.getDireccion());
        patient.setFechaNacimiento(dto.getFechaNacimiento());
        patient.setGenero(genero);


        PatientEntity patientEntity = patientRepository.save(patient);

        return MapperUser.toGetDto(savedUser);
    }


}