package com.example.livraria.controller;

import com.example.livraria.model.Livro;
import com.example.livraria.service.LivroService;
import jakarta.validation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livraria")
public class LivroController {

    private final LivroService service;
    //para que as regras do service possam ser utilizadas aqui
    public LivroController(LivroService service){
        this.service = service;
    }

    @GetMapping
    public List<Livro> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Livro buscarId(@PathVariable Long id){
        return service.buscarId(id);
    }

    @GetMapping("/buscar")
    public List<Livro> buscarPorTitulo(@RequestParam String titulo){
        return service.buscarPorTitulo(titulo);
    }

    @PostMapping
    public Livro salvar(@RequestBody @Valid Livro livro){ //transforma as informações JSON para Java e valida conforme o model
        return service.salvar(livro);
    }
    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody @Valid Livro livro){
        return service.atualizar(id, livro);
    }

    @DeleteMapping ("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}