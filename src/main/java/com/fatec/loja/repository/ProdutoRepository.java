package com.fatec.loja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.fatec.loja.entity.ProdutoEntity;


@Repository
public interface ProdutoRepository  extends JpaRepository<ProdutoEntity, Integer>, JpaSpecificationExecutor<ProdutoEntity>{
    
    Optional<ProdutoEntity> findByCodigo(int codigo);
  
}
