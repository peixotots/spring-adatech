package com.taina.santander_coders.controller;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.service.ObterUsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService service;

    public UsuarioController(ObterUsuarioService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id){

        return service.execute(id);
    }
}
