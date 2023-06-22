package com.fatec.loja;

import com.fatec.loja.repository.CestaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CestaService {
    @Autowired
    private CestaRepository cestaRepository;


}
