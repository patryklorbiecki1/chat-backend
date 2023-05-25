package pl.backend.chat.repository;

import pl.backend.chat.model.Message;

public interface ChatMessageBus {
    void emit(Message message);
}
