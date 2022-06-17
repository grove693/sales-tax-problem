package model.item;

import lombok.Builder;
import model.ProductType;

public class GeneralItem extends BaseSaleItem {

    @Builder
    public GeneralItem(int quantity, double price, String name, boolean isImported) {
        super(quantity, price, name, isImported);
    }

    public ProductType getType() {
        return ProductType.GENERAL;
    }
}
