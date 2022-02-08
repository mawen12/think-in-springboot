package com.mawen.spock.test.chapter4.lifecycle;

import com.mawen.spock.test.chapter4.Basket;
import com.mawen.spock.test.chapter4.Product;

import java.util.Map;

/**
 * 计费购物车
 * @author mawen
 * @create 2022-02-08 14:15
 */
public class BillableBasket extends Basket {

    private CreditCardProcessor creditCardProcessor;

    public BillableBasket() {
        System.out.println("BillableBasket is starting");
    }

    public void checkout() {
        if (creditCardProcessor == null) {
            return;
        }
        int total = 0;
        for (Map.Entry<Product, Integer> entry : contents.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        creditCardProcessor.charge(total);
    }

    public void setCreditCardProcessor(CreditCardProcessor creditCardProcessor) {
        this.creditCardProcessor = creditCardProcessor;
    }
}
