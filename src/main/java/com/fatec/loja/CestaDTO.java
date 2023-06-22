package com.fatec.loja;

import com.fatec.loja.entity.ClienteEntity;
import com.fatec.loja.entity.ProdutoEntity;

public class CestaDTO {

    private int sessionId;
    private ClienteEntity codigoCliente;
    private ProdutoEntity codigoProduto;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;
}
