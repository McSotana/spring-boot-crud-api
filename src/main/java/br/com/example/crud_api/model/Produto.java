package br.com.example.crud_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Marca a classe como uma entidade JPA
@Table(name = "produtos") // Especifica o nome da tabela no banco de dados
public class Produto {

    @Id // Define o campo
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a geração automática do valor da chave primária pelo banco de dados
    private Long id; // Chave primária
    private String nome; // Acessível apenas dentro da própria classe
    private String descricao;
    private double preco; // Declara uma variável do tipo double (representa números de ponto flutuante de precisão dupla) restrito à classe

    // Getters (sados para obter o valor de um atributo privado de uma classe) e Setters (São usados para definir ou atualizar o valor de um atributo privado)
    public Long getId() { // public (modificador de acesso que indica que um método ou variável pode ser acessado de qualquer lugar no código)
        return id;       // Long (dado primitivo que representa números inteiros de 64 bits)
    }

    public void setId(Long id) { // void (retorno que indica que um método não retorna nenhum valor)
        this.id = id;
    }

    public String getNome() { // String (classe que representa cadeias de caracteres)
        return nome; // return (sair de um método e, opcionalmente, retornar um valor para quem o chamou)
    }

    public void setNome(String nome) {
        this.nome = nome; // this (objeto atual dentro de uma classe, permitindo o acesso aos seus membros (atributos e métodos))
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}