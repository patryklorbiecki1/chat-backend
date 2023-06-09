package pl.backend.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(schema = "public",name="message")
public class Message {
    @Id
    @Column(name="message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;
    @Column(name="message_sender")
    private String sender;
    @Column(name="message_content")
    private String content;
    @Column(name="message_timestamp")
    private String timestamp;
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;
}
