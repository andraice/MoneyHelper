package com.moneyhelper.moneyhelper.models;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.orm.SugarContext;
import com.orm.SugarDb;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

/**
 * Created by ORACLE on 02/07/2016.
 */
public class MoneyHelperService {

    public boolean addOperation(String amount, String typeOperation) {
        Operation operation = new Operation();
        operation.setAmount(Float.parseFloat(amount));
        operation.setTypeOperation(typeOperation);
        operation.setCreatedAt(new Date());
        return operation.save() > 0;
    }

    public boolean addAccount(String name) {
        Account account = new Account();
        account.setName(name);
        return account.save() > 0;
    }

    public boolean addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        return category.save() > 0;
    }

    public List<Account> getAccounts() {
        Account account = new Account();
        return account.getAccounts();
    }
    public List<Category> getCategories() {
        Category category = new Category();
        return category.getCategories();
    }



    public float getTotalAmount() {
        try {
            float ingreso = 0;
            float egreso = 0;
            Cursor cursorIngreso = getDatabase().rawQuery(
                    "SELECT SUM(amount) AS result FROM operation where type_operation = 'INGRESO'", null);
            ingreso = cursorIngreso.moveToFirst() ? cursorIngreso.getInt(cursorIngreso.getColumnIndex("result")) :  0;

            Cursor cursorEgreso = getDatabase().rawQuery(
                    "SELECT SUM(amount) AS result FROM operation where type_operation = 'EGRESO'", null);
            egreso = cursorEgreso.moveToFirst() ? cursorEgreso.getInt(cursorEgreso.getColumnIndex("result")) :  0;

            return (ingreso - egreso);
        }
        catch(NullPointerException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private SQLiteDatabase getDatabase() {
        try {
            Field f = SugarContext.getSugarContext().getClass().getDeclaredField("sugarDb");
            f.setAccessible(true);
            return ((SugarDb) f.get(SugarContext.getSugarContext())).getDB();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteAllOperations() {

        Operation operation = new Operation();
        operation.deleteAll();

    }
}
