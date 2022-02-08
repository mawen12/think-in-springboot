package com.mawen.spock.test.chapter4.structure;

import com.mawen.spock.test.chapter4.Basket;
import com.mawen.spock.test.chapter4.Product;

import java.util.Map;

/**
 * @author mawen
 * @create 2022-02-08 14:36
 */
public class EnterprisyBasket extends Basket {

    private WarehouseInventory warehouseInventory;

    public void enableAutoRefresh() {

    }

    public void setNumberOfCaches(int number) {

    }

    public void setCustomerResolver(DefaultCustomerResolver defaultCustomerResolver) {

    }

    public void setWarehouseInventory(WarehouseInventory warehouseInventory) {
        this.warehouseInventory = warehouseInventory;
    }

    public void setLanguage(String language) {

    }

    public void checkout() {
        for (Map.Entry<Product, Integer> entry : contents.entrySet()) {
            warehouseInventory.subtract(entry.getKey().getName(), entry.getValue());
        }
    }
}
