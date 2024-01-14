package ma.tnb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TnbServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TnbServiceApplication.class, args);
    }

}
