package com.taina.santander_coders.controller;

import com.taina.santander_coders.model.Usuario;
import com.taina.santander_coders.service.CriarUsuarioService;
import com.taina.santander_coders.service.ObterUsuarioPorFiltroService;
import com.taina.santander_coders.service.ObterUsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final ObterUsuarioService service;
    private final CriarUsuarioService criarUsuarioService;
    private final ObterUsuarioPorFiltroService obterUsuarioPorFiltroService;

    public UsuarioController(ObterUsuarioService service, CriarUsuarioService criarUsuarioService, ObterUsuarioPorFiltroService obterUsuarioPorFiltroService) {
        this.service = service;
        this.criarUsuarioService = criarUsuarioService;
        this.obterUsuarioPorFiltroService = obterUsuarioPorFiltroService;
    }

    // Metodo responsável por criar um novo usuário no banco de dados através de uma requisição POST
    // Recebe o objeto Usuario no corpo da requisição (@RequestBody) e retorna o ResponseEntity com o status 201
    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(criarUsuarioService.executar(usuario));
    }

    @GetMapping("/{id}")
    public Usuario obterUsuarioPorId(@PathVariable Long id){

        return service.execute(id);
    }

    @GetMapping("/nome")
    public List<Usuario> obterUsuarioPorNome(@RequestParam String nome){
        return obterUsuarioPorFiltroService.obterUsuarioPorNome(nome);
    }

    @GetMapping("/cpf")
    public Usuario obterUsuarioPorCpf(@RequestParam String cpf){
        return obterUsuarioPorFiltroService.obterUsuarioPorCpf(cpf);
    }

    @GetMapping
    public Page<Usuario> obterUsuarios(Pageable pageable){
        return obterUsuarioPorFiltroService.execute(pageable);
    }

}
