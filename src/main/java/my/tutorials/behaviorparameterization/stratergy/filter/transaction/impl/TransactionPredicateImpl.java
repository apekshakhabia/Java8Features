package my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl;

import my.tutorials.model.Transaction;
import my.tutorials.model.TxnType;

import java.util.function.Predicate;

public class TransactionPredicateImpl {

    public static Predicate<Transaction> amountGreaterThanPredicate(Double amount){

        return t -> t.getAmount() > amount;
    }

    public static Predicate<Transaction> amountCreditAndSourcePredicate(Double amount){

        return t -> (t.getAmount() > amount) && t.getType() == TxnType.CREDIT && t.getSource().equalsIgnoreCase("X");
    }
}
