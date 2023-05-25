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
import org.springframework.web.bind.annotation.RestController;

import com.fatec.loja.entity.ClienteEntity;

@RestController
@CrossOrigin(origins = "*")
public class ClienteController {
    
    @Autowired
    private ClienteService service;
   
    @GetMapping("/api/cliente/{codigo}")
    public ResponseEntity<ClienteDTO> carregar(@PathVariable int codigo){
        ClienteDTO obj = service.carregar(codigo);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/api/cliente")
    public ResponseEntity<String> gravar(@RequestBody ClienteDTO obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem); 
    }
    
    
    @PutMapping("/api/cliente/")
    public ResponseEntity<String> atualizar(@RequestBody ClienteDTO obj){
        String mensagem = service.gravar(obj);
        return ResponseEntity.ok(mensagem); 
    }

    @DeleteMapping("/api/cliente/{codigo}")
    public ResponseEntity<String> remover(@PathVariable int codigo){
        String menString = service.remover(codigo);
        return ResponseEntity.ok(menString);
    }


    @GetMapping("/api/clientes")
    public ResponseEntity<List<ClienteEntity>> listar(){
        return ResponseEntity.ok(service.listar());
    }


    @PostMapping("/api/cliente/login")
    public ResponseEntity<ClienteDTO> fazerLogin(@RequestBody ClienteDTO dto){
        return ResponseEntity.ok(service.fazerLogin(dto));
    }

}
