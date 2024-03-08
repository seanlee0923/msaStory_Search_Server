package com.msastory.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.msastory.search.domain.NexonApi;

@Configuration
public class ApiConfig {
    
    @Value("${api.key}")
    private String apiKey;
    private String basicUrl = "https://open.api.nexon.com/maplestory/v1/";

    @Bean
    public NexonApi nexonApi() {
        return new NexonApi(apiKey, basicUrl);
    }
}
