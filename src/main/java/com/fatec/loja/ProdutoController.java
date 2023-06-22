package com.fatec.loja;

import java.util.List;

import com.fatec.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.loja.entity.ProdutoEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    private ProdutoRepository repository;

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
