package br.com.serratec.commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.commerce.models.LancamentoVendas;

@Repository
public interface ILancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}