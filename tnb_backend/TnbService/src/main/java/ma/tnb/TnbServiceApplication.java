package ma.tnb;

import ma.tnb.services.TnbService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TnbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TnbServiceApplication.class, args);
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().baseUrl("http://localhost:8080/api/").build();
    }

    @Bean
    public CommandLineRunner commandLineRunner(TnbService tnbService) {
        return args -> {
//            System.out.println(tnbService.calculateTnb(3L, 2L, 2L));
//
//            Client clt = webClient.get().uri("/land-service/clients/2").retrieve().bodyToMono(Client.class).block();
//            System.out.println(clt.toString());
//
//            Land lad = webClient.get().uri("/land-service/lands/2").retrieve().bodyToMono(Land.class).block();
//            System.out.println(lad.toString());
//
//            Rate rat = webClient.get().uri("/tax-service/rates/3").retrieve().bodyToMono(Rate.class).block();
//            System.out.println(rat.toString());
//
//            Category cat = webClient.get().uri("/land-service/categories/" + rat.getCategoryId()).retrieve().bodyToMono(Category.class).block();
//            System.out.println(cat.toString());
//
//            System.out.println((lad.getSurface() * cat.getRising() * rat.getRatePercent()) / 100);
//
//            Mono<List<Land>> listMono = webClient.get().uri("/land-service/lands")
//                    .accept(MediaType.APPLICATION_JSON).retrieve()
//                    .bodyToMono(new ParameterizedTypeReference<List<Land>>() {});
//
//            listMono.block().forEach(l -> {
//                System.out.println(l.toString());
//            });
//
//            tnbService.findAllTaxesByClient(2L).forEach(l -> {
//                System.out.println(l.toString());
//            });
        };
    }
}
