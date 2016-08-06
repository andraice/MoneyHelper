package com.moneyhelper.moneyhelper.models;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by ORACLE on 02/07/2016.
 */
public class Account extends SugarRecord {
    private String name;

    public Account() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccounts(){
        List<Account> accounts = Account.listAll(Account.class);
        return accounts;
    }

    @Override
    public String toString() {
        return name;
    }

}
