package com.example.livraria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Entity //define a tabela no banco de dados
@Getter
@Setter
public class Livro {

    @Id //define a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk autoincrement
    private Long id;

    @NotBlank(message = "Campo obrigatório.") //impede a falta de texto
    private String titulo;

    @NotBlank(message = "Campo obrigatório.")
    private String autor;

    @NotNull(message = "Campo obrigatório.")
    @Positive(message = "Valor inválido.")
    private Double preco;

    @Min(0)
    private Integer estoque;

    @NotBlank(message = "Campo obrigatório.")
    @Column(unique = true) //configura o atributo como único no banco de dados
    private String ISBN;

    public Livro(){}
}
