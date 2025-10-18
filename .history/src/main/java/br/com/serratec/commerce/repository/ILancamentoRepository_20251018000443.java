package br.com.serratec.commerce.repository;

import br.com.serratec.entity.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}