package br.com.rmservicos.hoc.repositories;

import br.com.rmservicos.hoc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
