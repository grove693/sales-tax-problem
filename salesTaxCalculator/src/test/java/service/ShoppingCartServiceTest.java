package service;

import model.item.*;
import model.receipt.Receipt;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.AssertUtils;

import java.util.List;
import java.util.stream.Stream;

class ShoppingCartServiceTest {

    private ShoppingCartService victim = new ShoppingCartService();

    @ParameterizedTest
    @MethodSource("happyFlowTestCases")
    void shouldGenerateReceipt(List<BaseSaleItem> items, Receipt expectedReceipt){
        Receipt actualReceipt = victim.generateReceipt(items);

        AssertUtils.assertEqualsDoubles(expectedReceipt.getTotalSalesTax(), actualReceipt.getTotalSalesTax());
        AssertUtils.assertEqualsDoubles(expectedReceipt.getTotal(), actualReceipt.getTotal());
    }




    static Stream<Arguments> happyFlowTestCases() {
        List<BaseSaleItem> itemsInput1 = List.of(
                BookItem.builder()
                        .name("book")
                        .quantity(1)
                        .price(12.49d)
                        .build(),
                GeneralItem.builder()
                        .name("music cd")
                        .quantity(1)
                        .price(14.99d)
                        .build(),
                FoodItem.builder()
                        .name("chocolate bar")
                        .quantity(1)
                        .price(0.85d)
                        .build()
        );

        Receipt expectedReceiptInput1 = Receipt.builder()
                .totalSalesTax(1.5d)
                .total(29.83d)
                .build();

        List<BaseSaleItem> itemsInput2 = List.of(
                FoodItem.builder()
                        .name("imported box of chocolates")
                        .quantity(1)
                        .isImported(true)
                        .price(10d)
                        .build(),
                GeneralItem.builder()
                        .name("imported bottle of perfume")
                        .quantity(1)
                        .isImported(true)
                        .price(47.5d)
                        .build()
        );

        Receipt expectedReceiptInput2 = Receipt.builder()
                .totalSalesTax(7.65d)
                .total(65.15d)
                .build();

        List<BaseSaleItem> itemsInput3 = List.of(
                GeneralItem.builder()
                        .name("imported bottle of perfume")
                        .quantity(1)
                        .isImported(true)
                        .price(27.99d)
                        .build(),
                GeneralItem.builder()
                        .name("bottle of perfume")
                        .quantity(1)
                        .price(18.99d)
                        .build(),
                MedicalItem.builder()
                        .name("packet of headache pills")
                        .quantity(1)
                        .price(9.75d)
                        .build(),
                FoodItem.builder()
                        .name("box of imported chocolates")
                        .quantity(1)
                        .isImported(true)
                        .price(11.25d)
                        .build()
        );

        Receipt expectedReceiptInput3 = Receipt.builder()
                .totalSalesTax(6.7d)
                .total(74.68d)
                .build();


        return Stream.of(
                Arguments.arguments(itemsInput1, expectedReceiptInput1),
                Arguments.arguments(itemsInput2, expectedReceiptInput2),
                Arguments.arguments(itemsInput3, expectedReceiptInput3)
        );
    }


}