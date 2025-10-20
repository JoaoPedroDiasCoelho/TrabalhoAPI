package br.com.serratec.commerce.data;

import br.com.serratec.commerce.models.VendedorAutonomo;
import br.com.serratec.commerce.models.VendedorProfissional;
import br.com.serratec.commerce.repository.IVendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private VendedorRepository vendedorRepository;

    private static final int NUMERO_REGISTROS = 1000;
    private final Random random = new Random();

    @Override
    public void run(String... args) throws Exception {
        // Verifica se a tabela já está populada para evitar duplicidade em "update"
        if (vendedorRepository.count() == 0) {
            System.out.println("Iniciando a popularização de 1000 registros na tabela Vendedor...");
            
            List<VendedorAutonomo> autonomos = new ArrayList<>();
            List<VendedorProfissional> profissionais = new ArrayList<>();

            for (int i = 1; i <= NUMERO_REGISTROS; i++) {
                // Alterna entre Vendedor Autônomo e Profissional
                if (i % 2 == 0) {
                    autonomos.add(criarVendedorAutonomo(i));
                } else {
                    profissionais.add(criarVendedorProfissional(i));
                }
            }
            
            // Salva todos os vendedores no banco de dados de uma vez (melhor performance)
            vendedorRepository.saveAll(autonomos);
            vendedorRepository.saveAll(profissionais);

            System.out.println("✅ Popularização de 1000 Vendedores concluída com sucesso!");
        }
    }

    /**
     * Cria e preenche um Vendedor Autônomo.
     */
    private VendedorAutonomo criarVendedorAutonomo(int index) {
        VendedorAutonomo va = new VendedorAutonomo();
        
        va.setNome("Autônomo #" + index);
        va.setEmail("autonomo" + index + "@vendasapi.com");
        
        // Salário entre R$ 1.500,00 e R$ 4.000,00
        BigDecimal salario = new BigDecimal(1500 + random.nextInt(2500))
                                .setScale(2, BigDecimal.ROUND_HALF_UP);
        va.setSalario(salario);
        
        // Comissão entre 5% e 20%
        BigDecimal comissao = new BigDecimal(random.nextDouble() * 0.15 + 0.05) 
                                .setScale(2, BigDecimal.ROUND_HALF_UP);
        va.setComissao(comissao); 
        
        return va;
    }

    /**
     * Cria e preenche um Vendedor Profissional.
     */
    private VendedorProfissional criarVendedorProfissional(int index) {
        VendedorProfissional vp = new VendedorProfissional();
        
        vp.setNome("Profissional #" + index);
        vp.setEmail("profissional" + index + "@vendasapi.com");
        
        // Salário entre R$ 3.000,00 e R$ 8.000,00
        BigDecimal salario = new BigDecimal(3000 + random.nextInt(5000))
                                .setScale(2, BigDecimal.ROUND_HALF_UP);
        vp.setSalario(salario);
        
        // Simula um CNPJ aleatório (apenas para preencher o campo obrigatório)
        String cnpj = String.format("%02d.%03d.%03d/0001-%02d", 
                                    random.nextInt(99), random.nextInt(999), 
                                    random.nextInt(999), random.nextInt(99));
        vp.setCnpj(cnpj); 
        
        return vp;
    }
}