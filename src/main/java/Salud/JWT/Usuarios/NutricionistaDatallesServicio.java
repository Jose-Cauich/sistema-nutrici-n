package Salud.JWT.Usuarios;

import Salud.entity.NutriologasEntity;
import Salud.repository.NutriologaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NutricionistaDatallesServicio implements UserDetailsService {


    NutriologaRepository nutriologaRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        NutriologasEntity nutriologas = nutriologaRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontro el correo: "+correo));

        //objeto user -implementaición
        return User.builder()
                .username(nutriologas.getCorreo())
                .password(nutriologas.getPasswordHash())
                .roles("NUTRICIONISTA")
                .build();
    }
}
