package meeting.plannner.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;



@Configuration
public class SwaggerConfig {

	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	
	@Bean
	public GroupedOpenApi publicApi() {
        logger.info("Configuring GroupedOpenApi for meeting-planner API");

        GroupedOpenApi api = GroupedOpenApi.builder()
                .group("meeting-planner")
                .packagesToExclude("meeting.plannner.repository", "meeting.plannner.service")
                .packagesToScan("meeting.plannner.controller")
                .build();

        logger.info("GroupedOpenApi for meeting-planner API configured successfully");

        return api;
	}
	
	@Bean
	public OpenApiCustomizer customiser() {
	    return openApi -> {
	        openApi.getPaths().remove("/service", "/repository"); // Exclut un chemin spécifique
	    };
	}

	
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	        .info(new Info()
	            .title("Meeting planner")
	            .version("1.0.0")
	            .description("book a meeting room")
	            .termsOfService("http://example.com/terms")
	            .contact(new Contact()
	                .name("Support API")
	                .url("http://example.com/contact")
	                .email("support@example.com"))
	            .license(new License()
	                .name("Apache 2.0")
	                .url("http://springdoc.org")))
	        ;
	}
}
