package ru.job4j.array;

import java.util.*;

public class Bank {
    private Map<UserForBank, List<AccountForBank>> listMap = new HashMap<>();

    public void addUser(UserForBank userForBank) {
        this.listMap.putIfAbsent(userForBank, null);
    }
    public void deleteUser(UserForBank userForBank) {
        this.listMap.remove(userForBank);
    }
    public Map<UserForBank, List<AccountForBank>> getListMap() {
        return this.listMap;
    }
    public UserForBank getUser(String passport) {
        Set<UserForBank> res = this.listMap.keySet();
        Iterator<UserForBank> it = res.iterator();
        for (int i = 0; i < res.size(); i++) {
            UserForBank resU = it.next();
            if (resU.getPassport().equals(passport)) {
                return resU;
            }
        }
        return null;
    }
    public List<AccountForBank> getUserAccounts(String passport) {
        UserForBank resU = this.getUser(passport);
        List<AccountForBank> resL = this.listMap.get(resU);
        if (resL != null) {
            return resL;
        }
        return null;
    }
    //добавить счёт пользователю.
    public boolean addAccountToUser(String passport, AccountForBank account) {
        if (this.getUserAccounts(passport) == null) {
            List<AccountForBank> resA = new ArrayList<>();
            resA.add(account);
            this.listMap.put(this.getUser(passport), resA);
        } else {
            AccountForBank resA = this.getAcc(passport, account.getRequisites());
            if (resA == null) {
                this.getUserAccounts(passport).add(account);
            }
        }
        return true;
    }
    // удалить один счёт пользователя
    public void deleteAccountFromUser(String passport, AccountForBank account) {
        List<AccountForBank> resA = this.getUserAccounts(passport);
        resA.remove(account);
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
    //метод для перечисления денег с одного счёта на другой счёт:
    public boolean transferMoneyTwo(String srcPassport, int srcRequisite, String destPassport, int dstRequisite, double amount) {
        UserForBank userOne = this.getUser(srcPassport);
        UserForBank userTwo = this.getUser(destPassport);
        AccountForBank accOne = this.getAcc(srcPassport, srcRequisite);
        AccountForBank accTwo = this.getAcc(destPassport, dstRequisite);
        if (userOne == null || userTwo == null || accOne == null || accTwo == null) {
            return false;
        }
        if (accOne.getValue() < amount) {
            return false;
        }
        accOne.downValue(amount);
        accTwo.upValue(amount);
        return true;
    }
}
