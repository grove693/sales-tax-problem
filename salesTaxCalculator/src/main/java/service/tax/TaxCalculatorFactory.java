package service.tax;

import model.ProductType;

import java.util.Map;

public final class TaxCalculatorFactory {

    private static final TaxCalculatorGeneralProducts TAX_CALCULATOR_GENERAL_PRODUCTS = new TaxCalculatorGeneralProducts();
    private static final TaxCalculatorTaxExemptProducts TAX_CALCULATOR_EXEMPT_PRODUCTS = new TaxCalculatorTaxExemptProducts();

    private static final Map<ProductType, TaxCalculator> TAX_CALCULATORS = Map.of(
            ProductType.GENERAL, TAX_CALCULATOR_GENERAL_PRODUCTS,
            ProductType.BOOKS, TAX_CALCULATOR_EXEMPT_PRODUCTS,
            ProductType.FOOD, TAX_CALCULATOR_EXEMPT_PRODUCTS,
            ProductType.MEDICAL, TAX_CALCULATOR_EXEMPT_PRODUCTS
    );

    public static TaxCalculator getTaxCalculator(ProductType type) {
        if (!TAX_CALCULATORS.containsKey(type)) {
            throw new IllegalStateException("Tax calculator mapping not complete");
        }
        return TAX_CALCULATORS.get(type);
    }
}
