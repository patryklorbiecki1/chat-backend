package pl.backend.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public",name = "user")
public class User {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name="user_username",unique = true)
    private String username;
    @Column(name="user_password")
    private String password;
    @Column(name="user_role")
    private String role;
    @Column(name="email", unique = true)
    private String email;
    @Column(name = "user_number",unique = true)
    private String number;
}
