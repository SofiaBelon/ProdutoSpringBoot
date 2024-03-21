package com.example.produto.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.produto.models.CategoriaProduto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaProdutoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public CategoriaProduto inserir(CategoriaProduto categoriaProduto){
        entityManager.merge(categoriaProduto);
        return categoriaProduto;
    }

    @Transactional
    public CategoriaProduto editar(CategoriaProduto categoriaProduto){
        entityManager.merge(categoriaProduto);
        return categoriaProduto;
    }

    @Transactional
    public void excluir(CategoriaProduto categoriaProduto){
        categoriaProduto = entityManager.merge(categoriaProduto);
        entityManager.remove(categoriaProduto);
    }

    public List<CategoriaProduto> selecionarTodos(){
        String jpql = "SELECT c FROM CategoriaProduto c";
        return entityManager.createQuery(jpql, CategoriaProduto.class).getResultList();
    }

    public List<CategoriaProduto> selecionarPorId(Long id) {
        String jpql = "SELECT c FROM CategoriaProduto c WHERE c.id = :id";
        TypedQuery<CategoriaProduto> query = entityManager.createQuery(jpql, CategoriaProduto.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

}
