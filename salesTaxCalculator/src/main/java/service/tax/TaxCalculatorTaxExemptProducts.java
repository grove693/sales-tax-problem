package service.tax;

public class TaxCalculatorTaxExemptProducts extends TaxCalculator {

    protected double getSalesTax() {
        return 0;
    }
}
