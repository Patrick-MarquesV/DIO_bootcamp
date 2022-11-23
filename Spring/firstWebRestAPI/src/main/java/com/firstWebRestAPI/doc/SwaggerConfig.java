package com.firstWebRestAPI.doc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    private Contact contato(){
        return new Contact("Patrick Marques",
                            "http://www.naotenhosite.com.br",
                            "patrick@semsite.com.br");
    }

    private ApiInfoBuilder informacoesApi(){

        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        apiInfoBuilder.title("Primeira - Rest API");
        apiInfoBuilder.description("Descrição da minha API");
        apiInfoBuilder.version("1.0");
        apiInfoBuilder.termsOfServiceUrl("Termo de uso: Open Source");
        apiInfoBuilder.license("Licença aberta");
        apiInfoBuilder.licenseUrl("http://www.naotemsite.com.br");
        apiInfoBuilder.contact(this.contato());

        return apiInfoBuilder;

    }

    @Bean
    public Docket detalheApi(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2);

        docket
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.firstWebRestAPI.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(this.informacoesApi().build())
                .consumes(new HashSet<String>(Arrays.asList("application/json")))
                .produces(new HashSet<String>(Arrays.asList("application/json")));

        return docket;

    }

}
