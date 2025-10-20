package br.com.serratec.commerce.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApiConfig() { 
        
        Server devServer = new Server();
        devServer.setUrl(devUri);
        devServer.setDescription("URL do Servidor de Desenvolvimento (Local/H2)");

        Server prodServer = new Server();
        prodServer.setUrl(prodUri);
        prodServer.setDescription("URL do Servidor de Produção (PostgreSQL)");

        Info info = new Info()
                .title("API de Gestão de Vendas com Herança JPA")
                .version("1.0.0")
                .description("API RESTful para gerenciar lançamentos de vendas e vendedores (Autônomo/Profissional), " +
                             "demonstrando o uso da estratégia de herança JOINED do Spring Data JPA.")
                .contact(new Contact()
                        .name("João Pedro Dias")
                        .email("joao.coelho@residente.serratec.org"))
                .license(new License()
                        .name("Licença Padrão")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html"));

        return new OpenAPI()
                .info(info)
                .servers(Arrays.asList(devServer, prodServer));
    }
}