package br.com.serratec.commerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    private final String devUri;
    private final String prodUri;

    public OpenApiConfig(
            @Value("${dominio.openapi.dev-uri:http://localhost:8080}") String devUri,
            @Value("${dominio.openapi.prod-uri:https://api.seudominio.com.br}") String prodUri) {
        this.devUri = devUri;
        this.prodUri = prodUri;
    }

    @Bean
    public OpenAPI openApiConfig() {
        
        Server devServer = new Server();
        devServer.setUrl(devUri);
        devServer.setDescription("URL do Servidor de Desenvolvimento (Local/H2)");

        Server prodServer = new Server();
        prodServer.setUrl(prodUri); // Agora injetado via construtor
        prodServer.setDescription("URL do Servidor de Produção (PostgreSQL)");

        Info info = new Info()
                // ... (restante da configuração de Info)
                .title("API de Gestão de Vendas com Herança JPA")
                .version("1.0.0")
                .description("API RESTful para gerenciar lançamentos de vendas e vendedores (Autônomo/Profissional), " +
                             "demonstrando o uso da estratégia de herança JOINED do Spring Data JPA.")
                .contact(new Contact()
                        .name("Seu Nome Aqui")
                        .email("seu.email@exemplo.com"))
                .license(new License()
                        .name("Licença Padrão")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html"));

        return new OpenAPI()
                .info(info)
                .servers(Arrays.asList(devServer, prodServer));
    }
}