package model.item;

import lombok.Builder;
import model.ProductType;

public class FoodItem extends BaseSaleItem {

    @Builder
    public FoodItem(int quantity, double price, String name, boolean isImported) {
        super(quantity, price, name, isImported);
    }

    @Override
    public ProductType getType() {
        return ProductType.FOOD;
    }
}
