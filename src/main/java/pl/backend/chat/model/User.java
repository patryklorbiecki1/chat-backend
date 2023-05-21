package pl.backend.chat.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    public enum Roles{
        ROLE_USER,ROLE_ADMIN,ROLE_MOD
    }
    @Column(name="user_roles",nullable = false)
    Set<Roles> roles = new HashSet<>();
}
