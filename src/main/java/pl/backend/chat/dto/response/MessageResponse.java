package pl.backend.chat.dto.response;

import lombok.Builder;

@Builder
public record MessageResponse(String message){}
