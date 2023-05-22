package pl.backend.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.chat.model.Chat;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
    Chat findByName(String name);
    List<Chat> findAllByDest_idOrOrigin_id(Integer dest_id,Integer origin_id);
}
