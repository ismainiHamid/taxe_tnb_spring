package ma.tnb.services;

import lombok.AllArgsConstructor;
import ma.tnb.metier.IMetier;
import ma.tnb.respense.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class TnbService implements IMetier {
    private WebClient webClient;

    @Override
    public Double calculateTnb(Integer rate, Long client, Long land) {
        Double result = null;

        Client clt = webClient.get().uri("/land-service/clients/" + client).retrieve().bodyToMono(Client.class).block();
        Land lad = webClient.get().uri("/land-service/lands/" + land).retrieve().bodyToMono(Land.class).block();
        Rate rat = webClient.get().uri("/tax-service/rates/" + rate).retrieve().bodyToMono(Rate.class).block();
        Category cat = null;

        if (Objects.nonNull(clt) && Objects.nonNull(lad) && Objects.nonNull(rat)) {
            cat = webClient.get().uri("/land-service/categories/" + rat.getCategoryId()).retrieve().bodyToMono(Category.class).block();
            if (Objects.nonNull(cat)) {
                result = (lad.getSurface() * cat.getRising() * rat.getRatePercent()) / 100;
            }
        }

        Tax tax = Tax.builder().taxRising(result)
                .year(rat.getYear())
                .rate(rat)
                .clientId(clt.getId())
                .landId(lad.getId())
                .categoryId(cat.getId())
                .build();

        Tax response = webClient.post().uri("/tax-service/taxes").contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(tax)).retrieve().bodyToMono(Tax.class).block();

        if (Objects.isNull(response)) {
            throw new RuntimeException("Tax not save in database !");
        }
        return result;
    }

    @Override
    public List<Land> findAllLandsByClient(Long client) {
        Mono<List<Land>> listMono = webClient.get().uri("/land-service/lands").accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Land>>() {
                });
        return listMono.block().stream().filter(l -> l.getClient().getId() == client).toList();
    }

    @Override
    public List<Tax> findAllTaxesByClient(Long client) {
        Mono<List<Tax>> listMono = webClient.get().uri("/tax-service/taxes").accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Tax>>() {
                });
        return listMono.block().stream().filter(t -> t.getClientId() == client).toList();
    }
}
