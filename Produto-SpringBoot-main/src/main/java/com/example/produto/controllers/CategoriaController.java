package com.example.produto.controllers;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.produto.models.CategoriaProduto;
import com.example.produto.repositories.CategoriaProdutoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("api/categoria-produto")
public class CategoriaController {
    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaController(CategoriaProdutoRepository categoriaProdutoRepository){
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @GetMapping()
    public List<CategoriaProduto> selecionarTodos() {
        return categoriaProdutoRepository.selecionarTodos();
    }

    @PostMapping()
    public void inserir(@RequestBody CategoriaProduto categoriaProduto){
        categoriaProdutoRepository.inserir(categoriaProduto);
    }


}
