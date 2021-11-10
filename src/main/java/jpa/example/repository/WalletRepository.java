package jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.example.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{
}
