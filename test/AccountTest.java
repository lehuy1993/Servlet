import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fa.training.dao.AccountDao;
import fa.training.dao.AccountDaoImpl;
import fa.traning.entities.Account;

public class AccountTest {
	private AccountDao accountDao;
	@Before
	public void init() {
		accountDao = new AccountDaoImpl();
	}
	@Test
	public void testSave() {
		Account account = new Account("admin", "admin123@gmaik.com","admin123");
		assertTrue(accountDao.saveAccount(account));
	}
}
