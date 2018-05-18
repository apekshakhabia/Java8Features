package my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;

import java.util.function.Consumer;

public class TransactionConsumerImpl {

    public static Consumer<Transaction> printTransactionsGreaterThanAmountConsumer() {

        return t -> {if(t.getAmount() > 3000d) System.out.println(t.toString());};
    }

    public static Consumer<Transaction> printTransactionWithCreditAndSourceConsumer() {

        return t -> {
            if (t.getAmount() > 3000d && t.getType() == TxnType.CREDIT && t.getSource().equalsIgnoreCase("X"))
                System.out.println(t.toString());
        };
    }

    public static Consumer<TransactionDetails> printTransactionDetails() {

        return t -> System.out.println(t.toString());
    }
}
