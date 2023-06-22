package com.fatec.loja;

import com.fatec.loja.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CestaController {
    @Autowired
    private ClienteService service;

    @GetMapping("/api/cesta/{codigo}")
    public ResponseEntity<ClienteDTO> carregar(@PathVariable int codigo){
        ClienteDTO obj = service.carregar(codigo);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/cesta")
    public ResponseEntity<String> gravar(@RequestBody ClienteDTO obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem);
    }


    @PutMapping("/api/cesta/")
    public ResponseEntity<String> atualizar(@RequestBody ClienteDTO obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem);
    }

    @DeleteMapping("/api/cesta/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        String menString = service.remover(codigo);
        return ResponseEntity.ok(menString);
    }
}
