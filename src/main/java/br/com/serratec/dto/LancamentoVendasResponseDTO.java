package br.com.serratec.dto;

import java.time.LocalDate;

import br.com.serratec.Entity.LancamentoVendas;

//Serve para enviar a resposta ao cliente (GET,POST,etc)
public class LancamentoVendasResponseDTO {
	 private LocalDate dataVenda;
	    private double valorVenda;
	    private String nomeVendedor;
	
	//transforma a entidade em DTO
	public LancamentoVendasResponseDTO(LancamentoVendas lanc) {
		 this.dataVenda = lanc.getData();
	        this.valorVenda = lanc.getValor();
	        this.nomeVendedor = lanc.getVendedor().getNome();
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public String getNomeVendedor() {
		return nomeVendedor;
	}

	public void setNomeVendedor(String nomeVendedor) {
		this.nomeVendedor = nomeVendedor;
	}

	
}
