package com.SpringAI.Helpdesk.helper;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserQueryRequest {
    @NotNull
    @NotBlank
    private String query;
}
