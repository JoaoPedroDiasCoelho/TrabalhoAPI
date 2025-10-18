package br.com.serratec.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.commerce.repository.ILancamentoRepository;

@Service
public class LancamentoService {
    
    @Autowired
    private ILancamentoRepository lancamentoRepository;

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        this.lancamentoRepository = lancamentoRepository;
    }
}
