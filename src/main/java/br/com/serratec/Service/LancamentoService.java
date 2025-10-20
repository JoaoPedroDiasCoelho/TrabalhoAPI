package br.com.serratec.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.Entity.LancamentoVendas;
import br.com.serratec.Entity.Vendedor;
import br.com.serratec.dto.LancamentoVendasResponseDTO;
import br.com.serratec.repository.LancamentoVendasRepository; 
import br.com.serratec.repository.VendedorRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoVendasRepository repository; 

    @Autowired
    private VendedorRepository vendedorRepository;
	
    
    //Novo lancamento
    public LancamentoVendasResponseDTO inserirLancamento(Long vendedorId, double valor) {
    	//verificar se o vendedor existe
        Vendedor vendedor = vendedorRepository.findById(vendedorId)
                .orElseThrow(() -> new RuntimeException("Vendedor não encontrado."));
        
        //cria um novo lancamento e da set no valor,vendedor e hora
        LancamentoVendas lanc = new LancamentoVendas();
        lanc.setData(LocalDate.now());
        lanc.setValor(valor);
        lanc.setVendedor(vendedor);
        //salva e retorna ao metodo
        repository.save(lanc); 
        return new LancamentoVendasResponseDTO(lanc);
    }
    //Listar por ID
    public LancamentoVendasResponseDTO listarPorId(Long id) {
        LancamentoVendas lanc = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lançamento não encontrado."));
        return new LancamentoVendasResponseDTO(lanc);
    }
}
