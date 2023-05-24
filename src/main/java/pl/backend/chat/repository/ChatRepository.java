package pl.backend.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.backend.chat.model.Chat;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Integer> {
    Chat findByName(String name);
    @Query(nativeQuery = true, value = "SELECT * FROM chat\n" +
            "WHERE origin_id = :#{#origin_id} OR dest_id = :#{#dest_id}")
    List<Chat> findAllByDestOrOrigin(Integer dest_id,Integer origin_id);
}
