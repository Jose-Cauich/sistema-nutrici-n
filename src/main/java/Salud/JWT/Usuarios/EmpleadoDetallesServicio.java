package Salud.JWT.Usuarios;

import Salud.entity.EmpleadosEntity;
import Salud.repository.EmpleadosRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@AllArgsConstructor
public class EmpleadoDetallesServicio implements UserDetailsService {

    EmpleadosRepository empleadosRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        EmpleadosEntity empleados = empleadosRepository.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("No se encontro el Empleado: "+correo));

        //objeto user -la implementación
        return User.builder()
                .username(empleados.getCorreo())
                .password(empleados.getPasswordHash())
                .roles("Empleado")
                .build();
    }
}
