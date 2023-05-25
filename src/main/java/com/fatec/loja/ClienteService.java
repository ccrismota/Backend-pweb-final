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
        repository.save(entity);

        return "tudo certo";
     }

     public ClienteDTO carregar(int codigo){
        ClienteDTO dto = new ClienteDTO();
        Optional<ClienteEntity> retorno = repository.findById(codigo);
        if(retorno.isPresent()){
            dto.setCodigo(retorno.get().getCodigo());
            dto.setNome(retorno.get().getNome());
            dto.setEmail(retorno.get().getEmail());
        }
        return dto;        
     }

    public String remover(int codigo) {
        ClienteEntity obj = new ClienteEntity();
        obj.setCodigo(codigo);
        repository.delete(obj);
        return "tudo certo";
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
