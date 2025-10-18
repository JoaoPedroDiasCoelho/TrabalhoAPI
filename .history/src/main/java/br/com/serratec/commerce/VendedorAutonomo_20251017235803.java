package br.com.serratec.commerce;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class VendedorAutonomo extends Vendedor {

    @NotNull
    @PositiveOrZero(message = "A comissão deve ser um valor positivo.")
    @Column(nullable = false)
    private BigDecimal comissao; // Campo adicional
}