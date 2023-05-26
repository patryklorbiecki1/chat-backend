package pl.backend.chat.dto.request;

import pl.backend.chat.model.Chat;
public record AddMessageRequest(String sender, String content, Chat chat,String timestamp) {}
