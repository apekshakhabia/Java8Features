package my.tutorials.behaviorparameterization.mapper;

import my.tutorials.model.Transaction;

public interface TransactionMapper {

    <T> T map(Transaction transaction);
}
