package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ObterUsuarioService {

    private final UsuarioRepository repository;

    public ObterUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Metodo responsável por buscar um usuário no banco de dados pelo id
    public Usuario execute(Long id){
        Optional<Usuario> usuario = repository.findById(id);

        return usuario.orElseThrow(() -> new RuntimeException(String.format("Usuário com id %d não encontrado", id)));
    }
}
