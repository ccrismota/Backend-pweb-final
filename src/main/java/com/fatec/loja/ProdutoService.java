package com.fatec.loja;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.loja.entity.ProdutoEntity;
import com.fatec.loja.repository.ProdutoRepository;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

   
    public ProdutoDTO buscarProduto(int codigo){
        ProdutoDTO dto = new ProdutoDTO();
        Optional<ProdutoEntity> retorno = produtoRepository.findById(codigo);
        if(retorno.isPresent()){
            dto.setCodigo(retorno.get().getCodigo());
            dto.setNome(retorno.get().getNome());
            dto.setPreco(retorno.get().getPreco());
            dto.setQuantidade(retorno.get().getQuantidade());
            dto.setDescricao(retorno.get().getDescricao());
        }
        return dto;        
     }


    public String cadastrarProduto(ProdutoDTO dto) {
       
        ProdutoEntity entity = new ProdutoEntity();

        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        entity.setDescricao(dto.getDescricao());
        produtoRepository.save(entity);

        return "Produto cadastrado com sucesso";
    }


    public String atualizar(ProdutoDTO dto) {
        ProdutoEntity entity = new ProdutoEntity();

        entity.setCodigo(dto.getCodigo());
        entity.setNome(dto.getNome());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        entity.setDescricao(dto.getDescricao());
        produtoRepository.save(entity);

        return "Produto atualizado com sucesso!!!";
    }

    public  List<ProdutoEntity> listarTodosProdutos() {
        return produtoRepository.findAll();
    }


    public String delete(int codigo) {
        ProdutoEntity obj = new ProdutoEntity();
        obj.setCodigo(codigo);
        produtoRepository.delete(obj);
        return "Produto excluído com sucesso!!!";
    }
}
