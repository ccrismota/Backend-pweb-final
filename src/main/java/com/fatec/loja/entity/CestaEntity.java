package com.fatec.loja.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "cesta")
public class CestaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @ManyToOne
    @JoinColumn(name = "codigoCliente")
    private ClienteEntity codigoCliente;

    @ManyToOne
    @JoinColumn(name = "codigoProduto")
    private ProdutoEntity codigoProduto;

    private int quantidade;
    private double valorUnitario;
    private double valorTotal;

    public int getSessionId() {
        return codigo;
    }

    public void setSessionId(int sessionId) {
        this.codigo = sessionId;
    }

    public ClienteEntity getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(ClienteEntity codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public ProdutoEntity getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(ProdutoEntity codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
