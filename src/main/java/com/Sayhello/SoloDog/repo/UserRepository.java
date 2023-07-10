package com.Sayhello.SoloDog.repo;
import org.springframework.data.repository.CrudRepository;
import com.Sayhello.SoloDog.models.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
