package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.CargoEntity;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.CargoRepository;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final CargoRepository cargoRepository;

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO createUsuario(UsuarioCreateDTO usuario) {
        UsuarioEntity novoUsuario = new UsuarioEntity();
        novoUsuario.setLogin(usuario.getLogin());
        novoUsuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        Set<CargoEntity> cargos = new HashSet<>();
        usuario.getCargos().forEach(cargo -> {
            CargoEntity cargoEntity = cargoRepository.findById(cargo.getId()).orElseThrow();
            cargos.add(cargoEntity);
        });
        novoUsuario.setCargos(cargos);
        return retornarDTO(usuarioRepository.save(novoUsuario));
    }
    public UsuarioDTO retornarDTO(UsuarioEntity usuarioEntity) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioEntity.getIdUsuario());
        return usuarioDTO;
    }

    public UsuarioEntity findById() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        Integer idUsuario = Integer.parseInt(authentication.getPrincipal().toString());
        return usuarioRepository.findById(idUsuario).orElseThrow();
//        Object usuario = authentication.toString();
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        return usuario;
    }

}