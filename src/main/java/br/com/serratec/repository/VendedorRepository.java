package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.Entity.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
