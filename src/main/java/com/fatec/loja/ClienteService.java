package com.fatec.loja;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.loja.entity.ClienteEntity;
import com.fatec.loja.repository.ClienteRepository;

@Service
public class ClienteService {
   
    @Autowired
    private ClienteRepository repository;
     
     public String gravar(ClienteDTO dto){
        ClienteEntity entity = new ClienteEntity();
        
        entity.setCodigo(dto.getCodigo());
        entity.setEmail(dto.getEmail());
        entity.setNome(dto.getNome());
        entity.setSenha(dto.getSenha());
        entity.setCpf(dto.getCpf());
        repository.save(entity);

        return "Cliente cadastrado com sucesso!";
     }

     public ClienteDTO carregar(int codigo){
        ClienteDTO dto = new ClienteDTO();
        Optional<ClienteEntity> retorno = repository.findById(codigo);
        if(retorno.isPresent()){
            dto.setCodigo(retorno.get().getCodigo());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
            dto.setCpf(retorno.get().getCpf());
        }
        return dto;        
     }

    public String remover(int codigo) {
        ClienteEntity obj = new ClienteEntity();
        obj.setCodigo(codigo);
        repository.delete(obj);
        return "Cliente removido com sucesso!";
    }

    public List<ClienteEntity> listar() {
        return  repository.findAll();
    }

    public ClienteDTO fazerLogin(ClienteDTO obj){
        ClienteDTO dto = new ClienteDTO();
        Optional<ClienteEntity> retorno = repository.fazerLogin(obj.getEmail(), obj.getSenha());
        if(retorno.isPresent()){
            dto.setCodigo(retorno.get().getCodigo());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;    
    }

}
