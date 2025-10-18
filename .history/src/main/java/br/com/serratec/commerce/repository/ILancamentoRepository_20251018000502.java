package br.com.serratec.commerce.repository;

import br.com.serratec.commerce.models.LancamentoVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}