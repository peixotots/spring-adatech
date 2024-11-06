package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterUsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioRepository usuarioRepository;

    public ObterUsuarioService(UsuarioRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    // Metodo responsável por buscar um usuário no banco de dados pelo id
    public Usuario execute(Long id){
        Optional<Usuario> usuario = repository.findById(id);

        return usuario.orElseThrow(() -> new RuntimeException(String.format("Usuário com id %d não encontrado", id)));
    }

    public Page<Usuario> execute(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }

}
