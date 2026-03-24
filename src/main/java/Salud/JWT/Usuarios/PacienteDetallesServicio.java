package Salud.JWT.Usuarios;

import Salud.entity.PacientesEntity;
import Salud.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteDetallesServicio implements UserDetailsService {

    private final PacienteRepository pacienteRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        PacientesEntity paciente = pacienteRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Paciente no encontrado con correo: " + correo));

        //objeto user -implementaición
        return User.builder()
                .username(paciente.getCorreo())
                .password(paciente.getPasswordHash())
                .roles("PACIENTE")
                .build();
    }
}
