package br.com.serratec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.Service.LancamentoService;
import br.com.serratec.dto.LancamentoVendasRequestDTO;
import br.com.serratec.dto.LancamentoVendasResponseDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoVendasController {

	@Autowired
	private LancamentoService service;
	
	//Inserir lancamento
	
	 @PostMapping
	 public ResponseEntity<LancamentoVendasResponseDTO> inserir(@Valid @RequestBody LancamentoVendasRequestDTO dto) {

	     LancamentoVendasResponseDTO novo = service.inserirLancamento(dto.getVendedorID(), dto.getValor());
	     return ResponseEntity.status(HttpStatus.CREATED).body(novo);
	 }

	    // Listar por ID
	    @GetMapping("/{id}")
	    public ResponseEntity<LancamentoVendasResponseDTO> listarPorId(@PathVariable Long id) {
	        LancamentoVendasResponseDTO dto = service.listarPorId(id);
	        return ResponseEntity.ok(dto);
	    }
}
