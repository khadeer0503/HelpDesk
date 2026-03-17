package com.SpringAI.Helpdesk.controllers;

import com.SpringAI.Helpdesk.Services.ChatService;
import com.SpringAI.Helpdesk.Services.TicketService;
import com.SpringAI.Helpdesk.helper.UserQueryRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/helpdesk")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Helpdesk AI Endpoints", description = "Endpoints for AI interactions in the Helpdesk system")
public class AiController {
    private final TicketService ticketService;
    private final ChatService chatService;


    @Operation(summary = "Generate response", operationId = "generate-response")
    @ApiResponse(responseCode = "200", description = "Successful response")
    @PostMapping(consumes = "application/json", produces = "application/json") // this is for Mintlify to execute and return the Api results
    public ResponseEntity<String> generateResponse(@RequestBody UserQueryRequest userQueryRequest) {
        log.info("Received user query: {}", userQueryRequest.getQuery());
        String aiResponse = chatService.getResponseFromAssistant(userQueryRequest.getQuery());
        log.info("Generated AI response: {}", aiResponse);
        return ResponseEntity.ok(aiResponse);
    }



}
