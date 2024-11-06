package com.taina.santander_coders.controller;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.service.CriarUsuarioService;
import com.taina.santander_coders.service.ObterUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService service;
    private final CriarUsuarioService criarUsuarioService;

    public UsuarioController(ObterUsuarioService service, CriarUsuarioService criarUsuarioService) {
        this.service = service;
        this.criarUsuarioService = criarUsuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuarioService.executar(usuario));
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id){

        return service.execute(id);
    }
}
