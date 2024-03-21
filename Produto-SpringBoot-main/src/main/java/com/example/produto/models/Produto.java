package com.example.produto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 200, nullable = false)
    private String prod_nome;
    @Column(nullable = false)
    private int qtd_produto;

    @ManyToOne
    @JoinColumn(name = "categoriaProduto_id")
    private CategoriaProduto categoriaProduto;

    
    public Produto(Long id, String prod_nome, int qtd_produto) {
        Id = id;
        this.prod_nome = prod_nome;
        this.qtd_produto = qtd_produto;
    }
    public Produto() {
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public String getProd_nome() {
        return prod_nome;
    }
    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }
    public int getQtd_produto() {
        return qtd_produto;
    }
    public void setQtd_produto(int qtd_produto) {
        this.qtd_produto = qtd_produto;
    }
    @Override
    public String toString() {
        return "Produto [Id=" + Id + ", prod_nome=" + prod_nome + ", qtd_produto=" + qtd_produto + "]";
    }
    public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
        this.categoriaProduto = categoriaProduto;
    }
}
