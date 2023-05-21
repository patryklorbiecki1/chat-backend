package pl.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.backend.model.Message;
@Repository
public interface MessageRepository extends JpaRepository<Message,Integer> {
}
