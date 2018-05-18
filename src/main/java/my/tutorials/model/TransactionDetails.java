package my.tutorials.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TransactionDetails {
    String type;
    String formattedAmount;
    String partiesInvolved;
}
