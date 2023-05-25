package com.fatec.loja;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.loja.entity.ProdutoEntity;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/api/produtos")
    public ResponseEntity<List<ProdutoEntity>> findAllProducts(){
        return ResponseEntity.ok(produtoService.listarTodosProdutos());
    }
    
    @GetMapping("/api/produto/{codigo}")
    public ResponseEntity<ProdutoDTO> buscarProduto(@PathVariable int codigo){
        ProdutoDTO obj = produtoService.buscarProduto(codigo);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/produto")
    @ResponseBody
    public ResponseEntity<String> cadastrar(@RequestBody ProdutoDTO objDto){
        String mensagem = produtoService.cadastrarProduto(objDto);
        return ResponseEntity.ok(mensagem); 
    }

    @PutMapping("/api/produto")
    public ResponseEntity<String> editarProduto(@RequestBody ProdutoDTO obj){
        String mensagem = produtoService.atualizar(obj);
        return ResponseEntity.ok(mensagem); 
    }

    @DeleteMapping("/api/produto/{codigo}")
    public ResponseEntity<String> deletarProduto(@PathVariable int codigo){
        String menString = produtoService.delete(codigo);
        return ResponseEntity.ok(menString);
    }

}
