package pl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.model.Chat;
@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
}
