package my.tutorials.behaviorparameterization.stratergy.filter.transaction;

import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;

import java.util.function.Supplier;

import static my.tutorials.model.TxnType.CREDIT;

public class FilterByAmount implements TransactionPredicate {

    @Override
    public boolean filter(Transaction transaction) {
        return transaction.getAmount()>2000;
    }

}
