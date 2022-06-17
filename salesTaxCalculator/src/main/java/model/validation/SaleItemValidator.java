package model.validation;

import model.item.BaseSaleItem;

import java.util.List;

public final class SaleItemValidator {

    public static void validateSaleItem(BaseSaleItem item) {
        if (item.getName().isEmpty()) {
            throw new IllegalArgumentException("Item has empty name");
        }

        if (item.getQuantity() <= 0) {
            throw new IllegalArgumentException("Item quantity has to be greater than zero");
        }

        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("Item price must be greater than zero");
        }
    }

    public static void validateItems(List<BaseSaleItem> items){
        items.forEach(SaleItemValidator::validateSaleItem);
    }
}
