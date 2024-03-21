package com.example.produto.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.produto.models.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produto inserir(Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public Produto editar(Produto produto){
        entityManager.merge(produto);
        return produto;
    }

    @Transactional
    public void excluir(Produto produto){
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
    }

    public List<Produto> selecionarTodos(){
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> selecionarPorId(Long id) {
        String jpql = "SELECT p FROM Produto p WHERE p.id = :id";
        TypedQuery<Produto> query = entityManager.createQuery(jpql, Produto.class);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
