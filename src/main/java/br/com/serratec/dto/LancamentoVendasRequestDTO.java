package br.com.serratec.dto;

//Serve para receber os dados da requisicao (POST)
public class LancamentoVendasRequestDTO {
	
	private double valor;
	
	private Long vendedorID;
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public Long getVendedorID() {
		return vendedorID;
	}
	public void setVendedorID(Long vendedorID) {
		this.vendedorID = vendedorID;
	}
	
	
}
