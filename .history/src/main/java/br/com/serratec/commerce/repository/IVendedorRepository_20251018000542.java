package br.com.serratec.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.commerce.models.Vendedor;

@Repository
public interface IVendedorRepository extends JpaRepository<Vendedor, Long> {
    // Repositório para a superclasse Vendedor (útil para popular)
}