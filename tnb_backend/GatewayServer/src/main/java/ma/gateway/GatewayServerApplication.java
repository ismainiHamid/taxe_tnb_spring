package ma.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServerApplication.class, args);
    }

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", a -> a
                        .path("/api/auth-service/**")
                        .uri("http://localhost:7474")
                ).route("land-service", l -> l
                        .path("/api/land-service/**")
                        .uri("http://localhost:7676")
                ).route("tax-service", t -> t
                        .path("/api/tax-service/**")
                        .uri("http://localhost:7878")
                ).build();
    }
}
