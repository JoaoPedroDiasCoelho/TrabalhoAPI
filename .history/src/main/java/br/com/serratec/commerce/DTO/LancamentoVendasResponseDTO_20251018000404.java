package br.com.serratec.commerce.DTO;

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
    
    public LancamentoVendasResponseDTO(LancamentoVendas vendas) {
        this.dataVenda = vendas.getData();
        this.valorVenda = vendas.getValor();
        this.nomeVendedor = vendas.getVendedor().getNome();
    }
}