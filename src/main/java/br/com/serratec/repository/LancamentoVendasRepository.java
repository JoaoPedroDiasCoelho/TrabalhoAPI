package br.com.serratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.Entity.LancamentoVendas;

@Repository
public interface LancamentoVendasRepository extends JpaRepository<LancamentoVendas, Long> {
}
