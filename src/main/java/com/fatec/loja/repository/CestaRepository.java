package com.fatec.loja.repository;

import com.fatec.loja.entity.CestaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CestaRepository extends JpaRepository<CestaEntity, Integer>,
        JpaSpecificationExecutor<CestaEntity> {
    Optional<CestaEntity> findByCodigo( CestaEntity codigo);


}
