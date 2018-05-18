package my.tutorials.behaviorparameterization;

import my.tutorials.behaviorparameterization.mapper.TransactionMapper;
import my.tutorials.model.Transaction;
import my.tutorials.model.TransactionDetails;
import my.tutorials.model.TxnType;
import org.junit.Before;
import org.junit.Test;

import static my.tutorials.behaviorparameterization.helper.TransactionMapperHelper.mapTransaction2String;
import static my.tutorials.behaviorparameterization.helper.TransactionMapperHelper.mapTransaction2TransactionDetails;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionMapperTest {

    private Transaction transaction;

    private TransactionMapper transactionMapper;

    @Before
    public void init() {
        transaction = new Transaction(TxnType.CREDIT, "Mark", "Spencer", 20000d);
    }

    @Test
    public void mapTransactionBasedOnClient1Requirement() {
        String transactionString = mapTransaction2String(transaction, new TransactionMapper() {
            @Override
            public String map(Transaction transaction) {
                return transaction.toString();
            }
        });

        assertThat(transactionString).isEqualTo("\n" +
                "Transaction(type = CREDIT, source = Mark, destination = Spencer, amount = 20000.0)");
    }

    @Test
    public void mapTransactionBasedOnClient2Requirement() {
        TransactionDetails transactionDetails = mapTransaction2TransactionDetails(transaction, new TransactionMapper() {
            @Override
            public TransactionDetails map(Transaction transaction) {
                return new TransactionDetails(transaction.getType().toString(), "$"+transaction.getAmount().toString(), transaction.getSource().toString()+":"+transaction.getDestination().toString());
            }
        });

        assertThat(transactionDetails.getType()).isEqualTo("CREDIT");
        assertThat(transactionDetails.getFormattedAmount()).isEqualTo("$20000.0");
        assertThat(transactionDetails.getPartiesInvolved()).isEqualTo("Mark:Spencer");
    }
}
