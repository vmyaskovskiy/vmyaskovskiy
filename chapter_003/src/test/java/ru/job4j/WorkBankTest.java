package ru.job4j;
import org.junit.Test;
import ru.job4j.array.AccountForBank;
import ru.job4j.array.BankTransfer;
import ru.job4j.array.UserForBank;

import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class WorkBankTest тестирование задачи части 003 - урок 3. Банковские переводы. [#10038]
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class WorkBankTest {
    @Test
    public void addUserAndGetUserTest() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        assertThat(bank.getUser("2323 343456").getName(), is("Vova"));
        assertThat(bank.getListUser().iterator().next().getName(), is("Vova"));
    }
    @Test
    public void addAccountToUserTest() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2323 343456", accountTree);
        assertThat(bank.getListMap().get(userOne).size(), is(2));
    }
    @Test
    public void addAccountToUserTestNegative() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2324 343456", accountTree);
        assertThat(bank.getListMap().get(userOne).size(), is(1));
    }
    @Test
    public void deleteAccountFromUserTest() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2323 343456", accountTree);
        bank.deleteAccountFromUser("2323 343456", accountTree);
        assertThat(bank.getListMap().get(userOne).size(), is(1));
        assertThat(bank.getUserAccounts("2323 343456").size(), is(1));
        assertThat(bank.getUserAccounts("2323 343456").get(0).getRequisites(), is(12345));
    }
    @Test
    public void getUserAccountsTest() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addAccountToUser("2323 343456", accountOne);
        assertThat(bank.getUserAccounts("2323 343456").get(0).getRequisites(), is(12345));
    }
    @Test
    public void transferMoneyTestFromUserOneToUserOne() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        UserForBank userTwo = new UserForBank("Slava", "2324 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTwo = new AccountForBank(200, 123456);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2324 343456", accountTwo);
        bank.addAccountToUser("2323 343456", accountTree);
        bank.transferMoney("2323 343456", 12345, "2323 343456", 123457, 50);
        assertThat(bank.getUserAccounts("2323 343456").iterator().next().getValue(), is(50.34));
        }
    @Test
    public void transferMoneyTestFromUserOneToUserTwo() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        UserForBank userTwo = new UserForBank("Slava", "2324 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2324 343456", accountTree);
        bank.transferMoney("2323 343456", 12345, "2324 343456", 123457, 50);
        assertThat(bank.getUserAccounts("2323 343456").iterator().next().getValue(), closeTo(50.34, 0.001));
        assertThat(bank.getUserAccounts("2324 343456").iterator().next().getValue(), closeTo(350.34, 0.001));
    }
    @Test
    public void transferMoneyTestFromUserOneToUserTwoNegativeEnoughMoney() {
        UserForBank userOne = new UserForBank("Vova", "2323 343456");
        UserForBank userTwo = new UserForBank("Slava", "2324 343456");
        AccountForBank accountOne = new AccountForBank(100.34, 12345);
        AccountForBank accountTree = new AccountForBank(300.34, 123457);
        BankTransfer bank = new BankTransfer();
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("2323 343456", accountOne);
        bank.addAccountToUser("2324 343456", accountTree);
        bank.transferMoney("2323 343456", 12345, "2324 343456", 123457, 150);
        assertThat(bank.getUserAccounts("2323 343456").iterator().next().getValue(), closeTo(100.34, 0.001));
        assertThat(bank.getUserAccounts("2324 343456").iterator().next().getValue(), closeTo(300.34, 0.001));
    }
}
