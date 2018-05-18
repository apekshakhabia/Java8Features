package my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;

import java.util.function.Supplier;

import static my.tutorials.model.TxnType.CREDIT;

public class TransactionSupplierImpl {

    public static Supplier<Transaction> returnTransaction() {

        return () -> {return new Transaction(CREDIT, "X", "Y", 30000d);};
    }

    public static Supplier<TransactionDetails> returnTransactionDetails() {

        return () -> new TransactionDetails("CREDIT", "$30000.0", "X:Y");
    }
}