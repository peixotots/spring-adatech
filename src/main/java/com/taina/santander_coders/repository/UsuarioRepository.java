package com.taina.santander_coders.repository;

import com.taina.santander_coders.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Parâmetros recebidos: a entidade que quero usar os métodos do JpaRepository (Usuario)
// e o tipo do id da entidade (Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
