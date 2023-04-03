package by.valsid.gym.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {
    private static final String AUTH_SCHEME = "Authorization";

    @Bean
    public OpenAPI openAuth() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(AUTH_SCHEME,
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")))
                .security(List.of(new SecurityRequirement().addList(AUTH_SCHEME)))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Gym");
    }
}
