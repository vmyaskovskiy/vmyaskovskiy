package ru.job4j.array;

import java.util.*;

/**
 * Class WorkBank решение задачи части 003 - Банковские переводы. [#10038].
 * @author vmyaskovskiy
 * @version $Id$
 * @since 0.1
 */
public class BankTransfer {
    private Map<UserForBank, List<AccountForBank>> listMap = new HashMap<>();
    private List<UserForBank> listUser = new ArrayList<>();
    public void addUser(UserForBank userForBank) {
        this.listUser.add(userForBank);
    }
    // найти пользователя по паспорту
    public UserForBank getUser(String passport) {
        UserForBank res = null;
        for (int i = 0; i < this.listUser.size(); i++) {
            if (this.listUser.get(i).getPassport().equals(passport)) {
                return this.listUser.get(i);
            }
        } return res;
    }
    // найти расчетный счет конкретного пользователя по реквезитам
    public AccountForBank getAcc(String passport, int requisites) {
        AccountForBank resA = null;
        List<AccountForBank> res = this.getUserAccounts(passport);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i).getRequisites() == requisites) {
                return res.get(i);
            }
        } return resA;
    }
    public List<UserForBank> getListUser() {
        return this.listUser;
    }
    public Map<UserForBank, List<AccountForBank>> getListMap() {
        return this.listMap;
    }
    //добавить счёт пользователю.
    public void addAccountToUser(String passport, AccountForBank account) {
        for (int i = 0; i < this.listUser.size(); i++) {
            UserForBank user = this.listUser.get(i);
            if (user.getPassport().equals(passport)) {
                if (this.listMap.get(user) == null) {
                    List<AccountForBank> resA = new ArrayList<>();
                    resA.add(account);
                    this.listMap.put(user, resA);
                } else {
                List<AccountForBank> resB = this.listMap.get(user);
                resB.add(account);
                this.listMap.put(user, resB);
                }
            }
        }
    }
    // удалить один счёт пользователя
    public void deleteAccountFromUser(String passport, AccountForBank account) {
        for (int i = 0; i < this.listUser.size(); i++) {
            UserForBank user = this.listUser.get(i);
            if (user.getPassport().equals(passport)) {
                List<AccountForBank> resA = this.listMap.get(user);
                resA.remove(account);
            }
            }
    }
    // получить список счетов для пользователя.
    public List<AccountForBank> getUserAccounts(String passport) {
        List<AccountForBank> res = new ArrayList<>();
        int l = this.listUser.size();
        for (int i = 0; i < l; i++) {
            UserForBank user = this.listUser.get(i);
            if (user.getPassport().equals(passport)) {
                return  this.listMap.get(user);
            }
        } return res;
    }
    //метод для перечисления денег с одного счёта на другой счёт:
    public boolean transferMoney(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        boolean res = true;
        UserForBank userOne = this.getUser(srcPassport);
        UserForBank userTwo = this.getUser(destPassport);
        AccountForBank accOne = this.getAcc(srcPassport, srcRequisite);
        AccountForBank accTwo = this.getAcc(destPassport, dstRequisite);
        if (userOne == null || userTwo == null || accOne == null || accTwo == null) {
            return false;
        }
        double amountAccOne = accOne.getValue();
        if (amountAccOne < amount) {
            return false;
        }
        double amountAccTwo = accTwo.getValue();
        this.getAcc(srcPassport, srcRequisite).setValue(amountAccOne - amount);
        this.getAcc(destPassport, dstRequisite).setValue(amountAccTwo + amount);
        return res;
    }
}
