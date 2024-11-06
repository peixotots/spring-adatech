package com.taina.santander_coders.repository;

import com.taina.santander_coders.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

// Parâmetros recebidos: a entidade que quero usar os métodos do JpaRepository (Usuario)
// e o tipo do id da entidade (Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Query Methods
    Optional<Usuario> findByCpf(String cpf);

    List<Usuario> findByNomeContaining(String nameContaining);

    // Paginação para busca de todos os usuários no banco de dados
    Page<Usuario> findAll(Pageable pageable);

}
