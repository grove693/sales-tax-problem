package service.tax;

import model.item.BaseSaleItem;
import utils.NumberUtils;

public abstract class TaxCalculator {

    protected static final double IMPORT_TAX = 5d;

    protected abstract double getSalesTax();

    public double computeTax(BaseSaleItem saleItem) {
        double totalTax = saleItem.isImported() ? getSalesTax() + IMPORT_TAX : getSalesTax();

        return NumberUtils.roundUpDouble(saleItem.getPrice() * saleItem.getQuantity() * totalTax / 100);
    }
}
