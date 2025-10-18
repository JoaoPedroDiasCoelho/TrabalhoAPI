package br.com.serratec.commerce;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import br.com.serratec.commerce.models.LancamentoVendas;


@Data
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