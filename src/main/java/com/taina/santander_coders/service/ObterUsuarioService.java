package com.taina.santander_coders.service;

import com.taina.santander_coders.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class ObterUsuarioService {

    public Usuario execute(Long id){
        return new Usuario("Sakura", 10, id);
    }
}
