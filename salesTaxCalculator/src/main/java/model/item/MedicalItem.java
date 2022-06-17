package model.item;

import lombok.Builder;
import model.ProductType;

public class MedicalItem extends BaseSaleItem {

    @Builder
    public MedicalItem(int quantity, double price, String name, boolean isImported) {
        super(quantity, price, name, isImported);
    }

    @Override
    public ProductType getType() {
        return ProductType.MEDICAL;
    }
}
