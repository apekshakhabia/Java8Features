package my.tutorials.behaviorparameterization.helper;


import my.tutorials.behaviorparameterization.stratergy.filter.transaction.TransactionPredicate;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TransactionHelper {

    private TransactionHelper(){}

    public static List<Transaction> findTransactionsGreaterThan2000(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > 2000d) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThan3000(List<Transaction> transactions) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > 3000d) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThanGivenAmount(List<Transaction> transactions, Double amount) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > amount) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> findTransactionsGreaterThanGivenAmountOfTypeCreditCarriedOutByX(
            List<Transaction> transactions,
            Double amount) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(transaction.getAmount() > amount
                    && TxnType.CREDIT.equals(transaction.getType())
                    && transaction.getSource().equalsIgnoreCase("X")) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }



    //List of Transactions to be sorted based on different comparison logic specified by the comparator
    public static List<Transaction> sortTransactions(List<Transaction> transactions, Comparator<Transaction> comparator) {
        transactions.sort(comparator);
        return transactions;
    }

    /*************************Apeksha's******************************/

    //Lamda and Functional Interface
    //Lets do code reuse - Code to iterate and add to the final list will be common. Only pass the filter condition.
    public static List<Transaction> filterTransactionByCustomPredicate(List<Transaction> transactions, TransactionPredicate predicate) {
        List<Transaction> filteredTransactions = new ArrayList<>();

        for(Transaction transaction : transactions) {
            if(predicate.filter(transaction)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public static List<Transaction> filterTransactionsWithPredicate(List<Transaction> transactions, Predicate<Transaction> predicate){
        List<Transaction> filteredTransactions = new ArrayList<>();
        for(Transaction transaction : transactions) {
            if(predicate.test(transaction))
                filteredTransactions.add(transaction);
        }
        return filteredTransactions;
    }

    public static void printTransactionsWithConsumer(List<Transaction> transactions, Consumer<Transaction> consumer){
        for(Transaction transaction : transactions) {
            consumer.accept(transaction);
        }
    }

    public static void printTransactionsDetailsWithConsumer(List<TransactionDetails> transactions, Consumer<TransactionDetails> consumer){
        for(TransactionDetails transactionDetails : transactions) {
            consumer.accept(transactionDetails);
        }
    }

    public static List<Transaction> addTransactionsWithSupplier(List<Transaction> transactionList, Supplier<Transaction> supplier){
        transactionList.add(supplier.get());
        return transactionList;
    }

    public static List<TransactionDetails> mapTransactionsWithFunction(List<Transaction> transactions, Function<Transaction, TransactionDetails> function){
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();
        for(Transaction transaction : transactions) {
            transactionDetailsList.add(function.apply(transaction));
        }
        return transactionDetailsList;
    }
}
