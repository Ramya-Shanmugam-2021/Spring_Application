package com.microservices.spring.Microservices_bankApp_accountService.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.microservices.spring.Microservices_bankApp_accountService.Entity.Account;
import jakarta.transaction.Transactional;


@SpringBootTest
@Transactional
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	
	@BeforeEach
    public void setUp() {
		Account account = new Account( 7,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
        accountRepository.save(account);
    }

    @Test
    public void testFindByCustomerId() {
      Account accounts = accountRepository.findByCustomerId(7);
        assertEquals(324241789, accounts.getAccountNumber());
    }
    
}



//	@Autowired
//	private TestEntityManager EntityManager;
//	
//	@Test
//	public void findByCustomerIdTest_success() {
//		System.out.println("line 1");
//		Account account = new Account( 1,324241789 , "savings","345,new delhi","Bank of India","2024-07-09");    
//		System.out.println("line 2");
//		EntityManager.persist(account);
//		System.out.println("line 3");
//		when(accountRepository.findByCustomerId(1)).thenReturn(account);
//		Account response = accountRepository.findByCustomerId(1);
//		System.out.println("line 4");
//		assertNotNull(response);
//
//	}

//	@Test
//	public void findByCustomerIdTest_success() {
//		//given
//		Account account = new Account( 1,324241718 , "savings","345,new delhi","Bank of India","2024-07-09");    
//		accountRepository.save(account);
//		Account savedAccount = accountRepository.findByCustomerId(account.getCustomerId());
//		System.out.println(" hi , i am from test class AccountRepositoryTest");
//		assertNotNull(savedAccount);
//		assertThat(savedAccount.getAccountType()).isEqualTo("savin");
//	}

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
