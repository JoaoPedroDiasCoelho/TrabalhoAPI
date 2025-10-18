package br.com.serratec.commerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class VendedorProfissional extends Vendedor {

    @NotBlank(message = "O CNPJ é obrigatório.")
    @Column(unique = true, length = 18, nullable = false)
    private String cnpj; // Campo adicional
}