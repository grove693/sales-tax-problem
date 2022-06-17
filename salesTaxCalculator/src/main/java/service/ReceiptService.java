package service;

import model.receipt.Receipt;
import model.receipt.ReceiptItem;
import model.item.BaseSaleItem;
import service.tax.TaxCalculator;
import service.tax.TaxCalculatorFactory;

import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReceiptService {

    public static Receipt createReceipt(List<BaseSaleItem> items) {
        List<ReceiptItem> receiptItems = items.stream()
                .map(saleItem -> {
                    TaxCalculator taxCalculator = TaxCalculatorFactory.getTaxCalculator(saleItem.getType());
                    return ReceiptItem
                            .builder()
                            .saleItem(saleItem)
                            .totalTax(taxCalculator.computeTax(saleItem))
                            .build();
                })
                .collect(Collectors.toList());

        return generateReceipt(receiptItems);
    }

    private static Receipt generateReceipt(List<ReceiptItem> receiptItems){
        return Receipt.builder()
                .issueDate(new Date())
                .items(receiptItems)
                .total(computeTotalPrice(receiptItems))
                .totalSalesTax(computeTotalSalesTax(receiptItems))
                .build();
    }

    private static Double computeTotalSalesTax(List<ReceiptItem> receiptItems) {
        return computeSumOfMetric(receiptItems, ReceiptItem::getTotalTax);
    }

    private static Double computeTotalPrice(List<ReceiptItem> receiptItems) {
        return computeSumOfMetric(receiptItems, ReceiptItem::getTotalPriceIncludingTax);
    }

    private static Double computeSumOfMetric(List<ReceiptItem> receiptItems, Function<ReceiptItem, Double> metricExtractor) {
        return receiptItems.stream()
                .map(metricExtractor)
                .reduce(0d, Double::sum);
    }
}