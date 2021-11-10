package jpa.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.example.model.WalletHistory;

public interface WalletHistoryRepository extends JpaRepository<WalletHistory, Long>{
}
