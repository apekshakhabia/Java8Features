package my.tutorials.behaviorparameterization;

import my.tutorials.helper.DataHelper;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static my.tutorials.behaviorparameterization.helper.TransactionHelper.addTransactionsWithSupplier;
import static my.tutorials.behaviorparameterization.helper.TransactionHelper.filterTransactionsWithPredicate;
import static my.tutorials.behaviorparameterization.helper.TransactionHelper.mapTransactionsWithFunction;
import static my.tutorials.behaviorparameterization.helper.TransactionHelper.printTransactionsDetailsWithConsumer;
import static my.tutorials.behaviorparameterization.helper.TransactionHelper.printTransactionsWithConsumer;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionConsumerImpl.printTransactionDetails;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionConsumerImpl.printTransactionWithCreditAndSourceConsumer;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionConsumerImpl.printTransactionsGreaterThanAmountConsumer;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionFunctionImpl.mapTransaction2TransactionDetails;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionPredicateImpl.amountCreditAndSourcePredicate;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionPredicateImpl.amountGreaterThanPredicate;
import static my.tutorials.behaviorparameterization.stratergy.filter.transaction.impl.TransactionSupplierImpl.returnTransaction;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionImplTest {

    private List<Transaction> transactionList = new ArrayList<>();

    @Before
    public void init() {
        //Given : List of Transactions
        transactionList = DataHelper.initTransactions();
    }

    @Test
    public void testTransactionsWithPredicate1() {
        List<Transaction> filteredTransactions = filterTransactionsWithPredicate(transactionList,
                amountGreaterThanPredicate(3000d));

        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(3000d);
        }
    }

    @Test
    public void testTransactionsWithPredicate2() {
        List<Transaction> filteredTransactions = filterTransactionsWithPredicate(transactionList,
                amountCreditAndSourcePredicate(3000d));

        for (Transaction filteredTransaction : filteredTransactions) {
            assertThat(filteredTransaction.getAmount()).isGreaterThan(3000d);
            assertThat(filteredTransaction.getType()).isEqualTo(TxnType.CREDIT);
            assertThat(filteredTransaction.getSource()).isEqualToIgnoringCase("X");
        }
    }

    @Test
    public void testTransactionsWithConsumer1(){
        printTransactionsWithConsumer(transactionList, printTransactionsGreaterThanAmountConsumer(3000d));
    }

    @Test
    public void testTransactionsWithConsumer2(){
        printTransactionsWithConsumer(transactionList, printTransactionWithCreditAndSourceConsumer(3000d));
    }

    @Test
    public void testTransactionsWithSupplier1(){
        List<Transaction> returnTransactionList =  addTransactionsWithSupplier(transactionList, returnTransaction());
        System.out.println(returnTransactionList);
    }

    @Test
    public void testTransactionsWithFunction() {
        List<TransactionDetails> transactionDetailsList = mapTransactionsWithFunction(transactionList, mapTransaction2TransactionDetails());
        printTransactionsDetailsWithConsumer(transactionDetailsList, printTransactionDetails());
    }
}
