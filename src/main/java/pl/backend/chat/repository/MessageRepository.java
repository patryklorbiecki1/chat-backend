package pl.backend.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.chat.model.Message;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {

    List<Message> findAllByChat_Name(String name);
}
