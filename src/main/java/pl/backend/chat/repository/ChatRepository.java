package pl.backend.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.chat.model.Chat;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
}
