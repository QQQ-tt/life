package com.tqsm.life.config;

import com.tqsm.life.interfaces.LifeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * @author qtx
 * @since 2023/8/21
 */
@Configuration
public class ClientConfig {

    @Value("${life.url}")
    private String lifeServiceUrl;

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                .baseUrl(lifeServiceUrl)
                .build();
    }

    @Bean
    public LifeClient requestService(WebClient webClient) {
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient))
                        .build();
        return proxyFactory.createClient(LifeClient.class);
    }
}
