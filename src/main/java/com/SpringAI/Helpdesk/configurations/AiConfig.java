package com.SpringAI.Helpdesk.configurations;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class AiConfig {
    private final ChatMemory chatMemory;
    private final ChatClient.Builder chatClient;

    @Bean
    public ChatClient  chatClient(ChatClient.Builder chatClient) {
        return chatClient
                    .defaultAdvisors(new SimpleLoggerAdvisor())
                    .build();
    }

}
