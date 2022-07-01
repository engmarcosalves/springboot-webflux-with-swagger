package br.com.geekcode.webflux.microservice.config


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.builders.ResponseBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.ResponseContext
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import java.util.*


@Configuration
@EnableSwagger2
class SpringFoxConfig {

    @Bean
    fun api(): Docket? {
        return Docket(DocumentationType.SWAGGER_2).select()
            .apis(RequestHandlerSelectors.basePackage("br.com.geekcode.webflux.microservice.controller"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(apiInfo())
            .useDefaultResponseMessages(false)
            .globalResponses(
                HttpMethod.GET, listOf(
                    ResponseBuilder()
                        .code("403")
                        .description("Forbidden !")
                        .build(),
                    ResponseBuilder()
                        .code("404")
                        .description("Not Found !")
                        .build()
                )
            )
            .globalResponses(
                HttpMethod.POST, listOf(
                    ResponseBuilder()
                        .code("201")
                        .description("201 Created")
                        .build(),
                    ResponseBuilder()
                        .code("404")
                        .description("Not Found !")
                        .build()
                )
            )
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfo(
            "TESTE REST API",
            "Some custom description of API.",
            "API v1.0.0",
            null,
            null,
            "Apache License, Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0",
            Collections.emptyList()
        )
    }
}