package com.raghu.sample.configuration;

import com.raghu.sample.utils.ExternalAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer{

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.withClassAnnotation(ExternalAPI.class)).build()
                .apiInfo(new ApiInfoBuilder().title("Demo-Api-Title").version("V1.0").build())
                .consumes(Stream.of(MediaType.APPLICATION_JSON_VALUE).collect(Collectors.toSet()))
                .produces(Stream.of(MediaType.APPLICATION_JSON_VALUE).collect(Collectors.toSet()));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/docs","/swagger-ui/index.html");
        registry.addRedirectViewController("/docs/","/swagger-ui/index.html");
    }
}
