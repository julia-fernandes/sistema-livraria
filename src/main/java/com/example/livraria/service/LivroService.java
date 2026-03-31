package com.example.livraria.service;

import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    //final para que o objeto utilize somente os métodos disponibilizados pela interface
    private final LivroRepository repository;

    public LivroService(LivroRepository repository){
        this.repository = repository;
    }

    public List<Livro> listar(){
        return repository.findAll();
    }

    public List<Livro> buscarPorTitulo(String titulo){
         return repository.findByTituloContainingIgnoreCase(titulo);
    }

    public Livro burcarId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado."));
    }

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
