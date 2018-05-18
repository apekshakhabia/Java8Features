package my.tutorials.behaviorparameterization.helper;

import my.tutorials.behaviorparameterization.mapper.TransactionMapper;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;

public class TransactionMapperHelper {

    public static String mapTransaction2String(Transaction transaction, TransactionMapper transactionMapper){
        return transactionMapper.map(transaction);
    }

    public static TransactionDetails mapTransaction2TransactionDetails(Transaction transaction, TransactionMapper transactionMapper){
        return transactionMapper.map(transaction);
    }
}
