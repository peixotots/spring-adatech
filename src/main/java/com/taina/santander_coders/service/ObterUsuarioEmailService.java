package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuarioEmailService {

    private final UsuarioRepository repository;

    public ObterUsuarioEmailService(UsuarioRepository repository) {
        this.repository = repository;
    }

//    public Usuario execute(String email){
//        return repository.encontrarPorEmail(email)
//                .orElseThrow(() -> new RuntimeException(String.format("Usuário com email %s não encontrado", email)));
//    }

    public Usuario execute(String email){
        return repository.encontrarPorEmailNative(email)
                .orElseThrow(() -> new RuntimeException(String.format("Usuário com email %s não encontrado", email)));
    }

}
