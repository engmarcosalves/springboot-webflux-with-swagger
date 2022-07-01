package br.com.geekcode.webflux.microservice.controller




import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono



@RestController
@Api(value = "TESTE", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = ["/v1"] )
class FunctionalHelloWorldController {

    @ApiOperation(value = "Retorna uma lista de pessoas")
    @ApiResponses(value = [
        ApiResponse(responseCode = "200", description = "Retorna mono"),
        ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
        ApiResponse(responseCode = "500", description = "Server Error")
    ])
    @GetMapping("/response-mono")
    fun helloMono(): ResponseEntity<Mono<String>>? {
        return ResponseEntity.ok(Mono.fromSupplier { "Hello SpringFox!" })
    }

    @PostMapping("/response-mono")
    fun testeMono(): ResponseEntity<Mono<String>>? {
        return ResponseEntity.ok(Mono.fromSupplier { "Hello SpringFox!" })
    }

}

//@Bean
//fun route(greetingHandler: GreetingHandler?): RouterFunction<ServerResponse?> {
//    return greetingHandler!!::hello.let {
//        RouterFunctions
//            .route(
//                RequestPredicates.GET("/hello")
//                    .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
//                it
//            )
//    }
//}
//
//@Component
//class GreetingHandler {
//    fun hello(request: ServerRequest?): Mono<ServerResponse> {
//        return ServerResponse.ok()
//            .contentType(MediaType.TEXT_PLAIN)
//            .body(BodyInserters.fromValue("Hello, SpringFox!"))
//    }
//}