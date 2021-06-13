package com.phuc.icommerce.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
//@OpenAPIDefinition(info = @Info(title = "I-Commerce APIs", version = "v1"))
public class openAPI {
//    @Bean
//    public OpenAPI icommerceOpenAPIConfig(Environment env) {
////        SecurityScheme securityScheme = new SecurityScheme();
////        securityScheme.type(SecurityScheme.Type.HTTP)
////                .scheme("bearer")
////                .bearerFormat("JWT");
////
////        Components components = new Components();
////        components.addSecuritySchemes("JWT", securityScheme);
//
//        return new OpenAPI();
////                .addSecurityItem(new SecurityRequirement().addList("JWT"))
////                .components(components);
//    }
//
//    @Bean
//    public OperationCustomizer customizeOperation() {
//        return (operation, handlerMethod) ->
//                operation.responses(
//                        operation.getResponses()
//                                .addApiResponse("400", new ApiResponse().description("Bad Request"))
//                                .addApiResponse("401", new ApiResponse().description("Unauthenticated"))
//                                .addApiResponse("403", new ApiResponse().description("Unauthorized"))
//                                .addApiResponse("500", new ApiResponse().description("Internal Server Error")));
//    }
}