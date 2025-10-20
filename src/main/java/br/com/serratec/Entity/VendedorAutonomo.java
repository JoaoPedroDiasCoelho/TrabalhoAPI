package br.com.serratec.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AUTONOMO") //Descriminante para coluna do pai
public class VendedorAutonomo extends Vendedor {

	private double comissao;

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	
	
}
