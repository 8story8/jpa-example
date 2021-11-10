package jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.example.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
