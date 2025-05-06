package com.petstore.Petstore.config;

import com.petstore.openapi.ApiClient;
import com.petstore.openapi.api.PetApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.petstore, com.petstore.")
public class BeanConfig {

    @Bean
    public ApiClient petStoreAPI () {
        return new ApiClient();
    }

    @Bean
    public PetApi petApi (ApiClient apiClient){
        return new PetApi(apiClient);
    }
}
