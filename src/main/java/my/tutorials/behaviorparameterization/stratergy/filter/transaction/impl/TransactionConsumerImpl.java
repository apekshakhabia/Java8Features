package my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;

import java.util.function.Consumer;

public class TransactionConsumerImpl {

    public static Consumer<Transaction> printTransactionsGreaterThanAmountConsumer(Double amount) {

        return t -> {if(t.getAmount() > amount) System.out.println(t.toString());};
    }

    public static Consumer<Transaction> printTransactionWithCreditAndSourceConsumer(Double amount) {

        return t -> {
            if (t.getAmount() > amount && t.getType() == TxnType.CREDIT && t.getSource().equalsIgnoreCase("X"))
                System.out.println(t.toString());
        };
    }

    public static Consumer<TransactionDetails> printTransactionDetails() {

        return t -> System.out.println(t.toString());
    }
}
