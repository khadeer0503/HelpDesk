package com.SpringAI.Helpdesk.configurations;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class AiConfig {

    @Bean
    public ChatClient  chatClient(ChatClient.Builder chatClient) {
        return chatClient.build();
    }

}
