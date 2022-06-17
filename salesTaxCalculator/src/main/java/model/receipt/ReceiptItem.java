package model.receipt;

import lombok.*;
import model.item.BaseSaleItem;
import utils.NumberFormatter;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptItem {

    @Getter(AccessLevel.NONE)
    private BaseSaleItem saleItem;

    private double totalTax;

    public double getTotalPriceIncludingTax() {
        return saleItem.getPrice() * saleItem.getQuantity() + totalTax;
    }

    @Override
    public String toString(){
        return String.format(
                "%s %s: %s",
                saleItem.getQuantity(),
                saleItem.getName(),
                NumberFormatter.convertToString(getTotalPriceIncludingTax())
        );
    }
}
