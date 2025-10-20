package br.com.serratec.commerce.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

    private final String devUri;
    private final String prodUri; // ⭐️ Renomeado para maior clareza

    // ⭐️ 1. Injeção via Construtor para garantir que os valores sejam resolvidos
    public OpenApiConfig(
            @Value("${dominio.openapi.dev-uri:http://localhost:8080}") String devUri,
            @Value("${dominio.openapi.prod-uri:https://api.seudominio.com.br}") String prodUri) { // ⭐️ O nome da propriedade é prod-uri
        this.devUri = devUri;
        this.prodUri = prodUri; // ⭐️ Atribui a variável correta
    }

    @Bean
    OpenAPI myOpenApi() {
        
        Server devServer = new Server();
        devServer.setUrl(devUri); // Usa a URL de dev
        devServer.setDescription("URL do Servidor de Desenvolvimento");

        Server prodServer = new Server();
        // ⭐️ CORREÇÃO CRUCIAL: Atribui a URL de produção ao objeto prodServer
        prodServer.setUrl(prodUri); 
        prodServer.setDescription("URL do Servidor de Produção");

        Contact contact = new Contact();
        contact.setEmail("jp.manerorc@gmail.com");
        contact.setName("Joao Dias");
        contact.setUrl("www.meudominio.com");

        Info info = new Info().title("API DE TESTE").version("1.0").contact(contact)
                .termsOfService("Api usada para testes");

        // Utiliza List.of() do Java 9+
        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}