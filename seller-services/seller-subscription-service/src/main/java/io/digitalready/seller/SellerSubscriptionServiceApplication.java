package io.digitalready.seller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class SellerSubscriptionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SellerSubscriptionServiceApplication.class, args);
	}

}
