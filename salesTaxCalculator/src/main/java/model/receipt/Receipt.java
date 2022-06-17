package model.receipt;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    private Date issueDate;

    private List<ReceiptItem> items;

    private double totalSalesTax;

    private double total;

    @Override
    public String toString() {
        String receiptStr =  items.stream()
                .map(ReceiptItem::toString)
                .reduce("", (prevAppended, currentStr) -> prevAppended + System.lineSeparator() + currentStr);

        receiptStr+= System.lineSeparator() + String.format("Sales tax: %.2f", totalSalesTax);
        receiptStr+= System.lineSeparator() + String.format("Total: %.2f", total);

        return receiptStr;
    }
}
