package jpa.example.service;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import jpa.example.model.User;
import jpa.example.model.WalletHistory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WalletServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private WalletService walletService;
	
	@BeforeEach
	public void setup() throws Exception {
		final String name = "user1";
		final String walletName = "wallet1";
		final User user = userService.registerUser(name);
		walletService.registerWallet(user, walletName);
	}
	
	@Test
	public void sendMoneyTest() throws Exception {
		WalletHistory walletHistory = walletService.sendMoney(1L, new BigDecimal("10"));
		System.out.println(walletHistory.toString());
	}

}
