package br.com.serratec.commerce.repository;

import br.com.serratec.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    // Repositório para a superclasse Vendedor (útil para popular)
}