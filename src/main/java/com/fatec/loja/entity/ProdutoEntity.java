package com.fatec.loja.entity;

import jakarta.persistence.*;

@Entity
@Table(name="produto")
public class ProdutoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="codigo")
    private int codigo;
    @Column(name="tituloGeral")
    private String tituloGeral;
    @Column(name="descricao")
    private String descricao;
    @Column(name="ingredientes")
    private String ingredientes;
    @Column(name="descricaoIngredientes")
    private String descricaoIngredientes;
    @Column(name="tituloIngrediente2")
    private String tituloIngrediente2;
    @Column(name="descricaoIngrediente2")
    private String descricaoIngrediente2;
    @Column(name="preco")
    private double preco;
    @Column(name="peso")
    private double peso;
    @Column(name="quantidade")
    private int quantidade;
    @Column(name="urlImage")
    private String urlImage;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTituloGeral() {
        return tituloGeral;
    }

    public void setTituloGeral(String tituloGeral) {
        this.tituloGeral = tituloGeral;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescricaoIngredientes() {
        return descricaoIngredientes;
    }

    public void setDescricaoIngredientes(String descricaoIngredientes) {
        this.descricaoIngredientes = descricaoIngredientes;
    }

    public String getTituloIngrediente2() {
        return tituloIngrediente2;
    }

    public void setTituloIngrediente2(String tituloIngrediente2) {
        this.tituloIngrediente2 = tituloIngrediente2;
    }

    public String getDescricaoIngrediente2() {
        return descricaoIngrediente2;
    }

    public void setDescricaoIngrediente2(String descricaoIngrediente2) {
        this.descricaoIngrediente2 = descricaoIngrediente2;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
