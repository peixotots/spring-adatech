package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioService {

    private final UsuarioRepository repository;

    public CriarUsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    // Metodo responsável por salvar a entidade Usuario passada como parâmetro no banco de dados
    public Usuario executar(Usuario usuarioQueSeraSalvo){
        Usuario usuarioPersistido = repository.save(usuarioQueSeraSalvo);
        return usuarioPersistido;
    }

}
