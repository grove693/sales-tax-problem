package model.item;

import lombok.*;
import model.ProductType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseSaleItem {

    private int quantity;
    private double price;
    private String name;
    private boolean isImported;

    public abstract ProductType getType();

}
