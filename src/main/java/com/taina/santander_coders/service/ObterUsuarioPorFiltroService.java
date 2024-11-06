package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ObterUsuarioPorFiltroService {

    private final UsuarioRepository repository;

    public ObterUsuarioPorFiltroService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario obterUsuarioPorCpf(String cpf){
        Optional<Usuario> optionalUsuario = repository.findByCpf(cpf);
            return optionalUsuario.orElseThrow(() -> new RuntimeException(String.format("Usuário com cpf %s não encontrado", cpf)));

    }

    public List<Usuario> obterUsuarioPorNome(String nome){
        return repository.findByNomeContaining(nome);
    }

}
