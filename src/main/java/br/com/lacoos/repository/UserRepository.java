package br.com.lacoos.repository;

import br.com.lacoos.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    boolean existsByEmailOrCpf(String email, String cpf);

    UserDetails findByEmail(String email);

    @Query("SELECT u FROM UserModel u WHERE u.email = ?1")
    Optional<UserModel> byEmail(String email);

}