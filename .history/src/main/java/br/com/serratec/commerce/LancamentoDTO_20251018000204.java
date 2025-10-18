package br.com.serratec.commerce;

import br.com.serratec.entity.LancamentoVendas;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class LancamentoVendasResponseDTO {
    
    private LocalDate dataVenda;
    private BigDecimal valorVenda;
    private String nomeVendedor;
    
    // Construtor para facilitar a conversão da Entity para DTO
    public LancamentoVendasResponseDTO(LancamentoVendas entity) {
        this.dataVenda = entity.getData();
        this.valorVenda = entity.getValor();
        this.nomeVendedor = entity.getVendedor().getNome();
    }
}