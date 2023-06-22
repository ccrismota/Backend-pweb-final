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
        Optional<ProdutoEntity> retorno = produtoRepository.findByCodigo(codigo);
        if(retorno.isPresent()){
            dto.setCodigo(retorno.get().getCodigo());
            dto.setTituloGeral(retorno.get().getTituloGeral());
            dto.setDescricao(retorno.get().getDescricao());
            dto.setIngredientes(retorno.get().getIngredientes());
            dto.setDescricaoIngredientes(retorno.get().getDescricaoIngredientes());
            dto.setTituloIngrediente2(retorno.get().getTituloIngrediente2());
            dto.setDescricaoIngrediente2(retorno.get().getDescricaoIngrediente2());
            dto.setPeso(retorno.get().getPeso());
            dto.setPreco(retorno.get().getPreco());
            dto.setQuantidade(retorno.get().getQuantidade());
        }
        return dto;        
     }

//    public ProdutoDTO buscarProdutoPorTitulo(String tituloGeral){
//        ProdutoDTO dto = new ProdutoDTO();
//        Optional<ProdutoEntity> retorno = produtoRepository.findByName(tituloGeral);
//        if(retorno.isPresent()){
//            dto.setCodigo(retorno.get().getCodigo());
//            dto.setTituloGeral(retorno.get().getTituloGeral());
//            dto.setDescricao(retorno.get().getDescricao());
//            dto.setIngredientes(retorno.get().getIngredientes());
//            dto.setDescricaoIngredientes(retorno.get().getDescricaoIngredientes());
//            dto.setTituloIngrediente2(retorno.get().getTituloIngrediente2());
//            dto.setDescricaoIngrediente2(retorno.get().getDescricaoIngrediente2());
//            dto.setPeso(retorno.get().getPeso());
//            dto.setPreco(retorno.get().getPreco());
//            dto.setQuantidade(retorno.get().getQuantidade());
//        }
//        return dto;
//    }


    public String cadastrarProduto(ProdutoDTO dto) {
       
        ProdutoEntity entity = new ProdutoEntity();

        entity.setCodigo(dto.getCodigo());
        entity.setTituloGeral(dto.getTituloGeral());
        entity.setDescricao(dto.getDescricao());
        entity.setIngredientes(dto.getIngredientes());
        entity.setDescricaoIngredientes(dto.getDescricaoIngredientes());
        entity.setTituloIngrediente2(dto.getTituloIngrediente2());
        entity.setDescricaoIngrediente2(dto.getDescricaoIngrediente2());
        entity.setPeso(dto.getPeso());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        entity.setUrlImage(dto.getUrlImage());
        produtoRepository.save(entity);

        return "Produto cadastrado com sucesso";
    }


    public String atualizar(ProdutoDTO dto) {
        ProdutoEntity entity = new ProdutoEntity();

        entity.setCodigo(dto.getCodigo());
        entity.setTituloGeral(dto.getTituloGeral());
        entity.setDescricao(dto.getDescricao());
        entity.setIngredientes(dto.getIngredientes());
        entity.setDescricaoIngredientes(dto.getDescricaoIngredientes());
        entity.setTituloIngrediente2(dto.getTituloIngrediente2());
        entity.setDescricaoIngrediente2(dto.getDescricaoIngrediente2());
        entity.setPeso(dto.getPeso());
        entity.setPreco(dto.getPreco());
        entity.setQuantidade(dto.getQuantidade());
        entity.setUrlImage(dto.getUrlImage());

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
