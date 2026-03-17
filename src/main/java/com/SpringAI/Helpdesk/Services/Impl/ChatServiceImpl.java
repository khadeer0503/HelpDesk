package com.SpringAI.Helpdesk.Services.Impl;

import com.SpringAI.Helpdesk.Services.ChatService;
import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatClient chatClient;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;

    @Override
    public String getResponseFromAssistant(String userQuery) {
        var metadata = chatClient
                .prompt()
                .system(systemPromptResource)
                .call()
                .chatResponse()
                .getMetadata();
        log.info("Model used for response: {}", metadata);

        // Basic call to llm
        var chat = this.chatClient
                .prompt()
                .system(systemPromptResource)
                .user(userQuery)
                .call()
                .chatResponse()
                .getResult()
                .getOutput()
                .getText();
              //  .content();
        log.info("Chat response using from userQuery: {}", chat);


        return chat;

    }
}
