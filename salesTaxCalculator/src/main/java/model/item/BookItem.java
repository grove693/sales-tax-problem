package model.item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import model.ProductType;

@Data
@AllArgsConstructor
public class BookItem extends BaseSaleItem {

    @Builder
    public BookItem(int quantity, double price, String name, boolean isImported) {
        super(quantity, price, name, isImported);
    }


    @Override
    public ProductType getType() {
        return ProductType.BOOKS;
    }
}
