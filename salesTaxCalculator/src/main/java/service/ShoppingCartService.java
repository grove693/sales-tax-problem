package service;

import model.receipt.Receipt;
import model.item.BaseSaleItem;
import model.validation.SaleItemValidator;

import java.util.List;

public class ShoppingCartService {

    public Receipt generateReceipt(List<BaseSaleItem> items) {
        SaleItemValidator.validateItems(items);

        Receipt receipt = ReceiptService.createReceipt(items);

        return receipt;
    }

}
