package br.com.serratec.commerce;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Estratégia de Herança
public abstract class Vendedor { // Classe Abstrata, não será instanciada
    
    // Salário Mínimo (Exemplo, use um valor configurável se for real)
    private Double salarioMinimo = 1412.00;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode ser nulo ou vazio.")
    @Column(nullable = false)
    private String nome;

    @NotBlank(message = "O e-mail não pode ser nulo ou vazio.")
    @Email(message = "E-mail com formato inválido.")
    @Column(unique = true, nullable = false)
    private String email;

    @NotNull(message = "O salário é obrigatório.")
    @DecimalMin(value = "1412.00", message = "O salário não pode ser inferior ao salário mínimo (R$ 1.412,00).")
    @Column(nullable = false)
    private BigDecimal salario;

    // Relacionamento: Um vendedor possui um ou vários lançamento de vendas
    @OneToMany(mappedBy = "vendedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LancamentoVendas> lancamentos;
}