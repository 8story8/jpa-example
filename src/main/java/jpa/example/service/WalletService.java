package jpa.example.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import jpa.example.model.User;
import jpa.example.model.Wallet;
import jpa.example.model.WalletHistory;
import jpa.example.repository.WalletHistoryRepository;
import jpa.example.repository.WalletRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WalletService {

	private final WalletRepository walletRepository;
	
	private final WalletHistoryRepository walletHistoryRepository;
	
	
	public Wallet registerWallet(User user, String name) {
		final Wallet wallet = Wallet.builder().name(name).user(user).balance(new BigDecimal("10000")).build();
		return walletRepository.save(wallet);
	}
	
	
	public WalletHistory sendMoney(Long fromWalletId, BigDecimal value) {
		return sendMoneyInternal(fromWalletId, value);
	}
	
	// to is skip.
	private WalletHistory sendMoneyInternal(Long fromWalletId, BigDecimal value) {
		final Wallet fromWallet = walletRepository.findById(fromWalletId).orElseThrow(()->new RuntimeException("wallet not found."));
		
		if(fromWallet.getBalance().compareTo(value) < 0) {
			throw new RuntimeException("invalid value.");
		}
	
		fromWallet.setBalance(fromWallet.getBalance().subtract(value));
		
		walletRepository.save(fromWallet);
		
		final WalletHistory fromWalletHistory = WalletHistory.builder().eventType("Withdrawal").balanceChange(value).wallet(fromWallet).build();
		
		return walletHistoryRepository.save(fromWalletHistory);
	}
}
