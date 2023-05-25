package pl.backend.chat.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.backend.chat.model.Chat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddMessageRequest {
    private String sender;
    private String content;
    private Chat chat;
    private String timestamp;
}
