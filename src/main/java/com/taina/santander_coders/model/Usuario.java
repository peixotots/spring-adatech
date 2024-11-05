package com.taina.santander_coders.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIO_SISTEMA")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NOME_USUARIO", nullable = false)
    private String nome;
    @Column(name = "IDADE", nullable = false)
    private int idade;
    @Column(name = "DOCUMENTO", unique = true)
    private String cpf;
    @Column(name = "DATA_HORA_CRIACAO")
    private LocalDateTime dataHoraCriacao;

    public Usuario(Long id, String nome, int idade, String cpf){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.dataHoraCriacao = LocalDateTime.now();
    }

    public Usuario() {
        this.dataHoraCriacao = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }
}
