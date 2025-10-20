package br.com.serratec.commerce.controller;

import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.entity.LancamentoVendas;
import br.com.serratec.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private br.com.serratec.commerce.service.LancamentoService lancamentoService;

    @GetMapping("/{id}")
    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
        LancamentoVendasResponseDTO dto = lancamentoService.listarPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<LancamentoVendasResponseDTO> inserirLancamento(@Valid @RequestBody LancamentoVendas lancamento) {
        LancamentoVendasResponseDTO dto = lancamentoService.inserirLancamento(lancamento);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}