package com.github.tddiaz.springpropertiesparsingdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@Slf4j
public class PortLocationConfig {

    @Value("#{${port.locations}}")
    private Map<String, String> data;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Bean
    public PortLocationRegistry portLocationRegistry() {
        PortLocationRegistry portLocationRegistry = new PortLocationRegistry();

        data.forEach((k,v) -> {
            try {
                portLocationRegistry.register(k, OBJECT_MAPPER.readValue(v, PortLocation.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        log.info("{}", portLocationRegistry.get("GBLGP"));
        log.info("{}", portLocationRegistry.get("GBSOU"));

        return portLocationRegistry;
    }
}
