package com.moneyhelper.moneyhelper.models;

import com.orm.SugarRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by ORACLE on 02/07/2016.
 */
public class Operation extends SugarRecord {
    private Date createdAt;
    private float amount;
    private String typeOperation;

    public Operation() {

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(String typeOperation) {
        this.typeOperation = typeOperation;
    }

    public List<Operation> getOperations(){
        List<Operation> operations = Operation.listAll(Operation.class);
        return operations;
    }

    public void deleteAll() {
        List<Operation> operations = Operation.listAll(Operation.class);
        Operation.deleteAll(Operation.class);
    }
}
