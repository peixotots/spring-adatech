package com.taina.santander_coders.repository;

import com.taina.santander_coders.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// Parâmetros recebidos: a entidade que quero usar os métodos do JpaRepository (Usuario)
// e o tipo do id da entidade (Long)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Query Methods
    Optional<Usuario> findByCpf(String cpf);
    List<Usuario> findByNomeContaining(String nameContaining);

    //JPQL = Java Persistence Query Language
    @Query(value = "SELECT u FROM Usuario u WHERE u.email = :email")
    Optional<Usuario> encontrarPorEmail(@Param("email") String email);

    //NATIVE
    @Query(value = "SELECT u.* FROM USUARIO_SISTEMA WHERE email = :email", nativeQuery = true)
    Optional<Usuario> encontrarPorEmailNative(@Param("email") String email);

}
