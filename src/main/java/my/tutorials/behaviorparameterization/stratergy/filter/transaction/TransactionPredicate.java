package my.tutorials.behaviorparameterization.stratergy.filter.transaction;

import my.tutorials.model.Transaction;

@FunctionalInterface
public interface TransactionPredicate {

    boolean filter(Transaction transaction);
}



