package com.taina.santander_coders.service;

import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuariosService {

    private final UsuarioRepository repository;

    public ObterUsuariosService(UsuarioRepository repository) {
        this.repository = repository;
    }

}
