package br.com.serratec.Entity;

import org.hibernate.validator.constraints.br.CNPJ;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("PROFISSIONAL") //Descriminante para coluna do pai
public class VendedorProfissional extends Vendedor{
	
	@CNPJ
	private String cnpj;

	
	
	//getters and setters
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	
}
