package pl.backend.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public",name = "chat")
public class Chat {
    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatId;
    @Column(name = "chat_name")
    private String name;
    @OneToOne
    @JoinColumn(name = "origin_id",referencedColumnName = "user_id")
    private User origin;
    @OneToOne
    @JoinColumn(name="dest_id",referencedColumnName = "user_id")
    private User dest;
}
