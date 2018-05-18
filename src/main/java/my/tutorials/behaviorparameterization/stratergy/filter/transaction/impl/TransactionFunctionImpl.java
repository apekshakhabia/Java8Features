package my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;

import java.util.function.Function;

public class TransactionFunctionImpl {

    public static Function<Transaction, String> mapTransaction2String(){

        return t -> t.toString();
    }

    public static Function<Transaction, TransactionDetails> mapTransaction2TransactionDetails(){

        return t -> new TransactionDetails(t.getType().toString(), "$"+t.getAmount().toString(), t.getSource().toString()+":"+t.getDestination().toString());
    }
}
