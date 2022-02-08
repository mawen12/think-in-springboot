package com.mawen.spock.test.chapter4.structure;

import com.mawen.spock.test.chapter4.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mawen
 * @create 2022-02-08 14:37
 */
public class WarehouseInventory {
    private int boxesMovedOut = 0;

    protected Map<String, Integer> inventory = new HashMap<>();

    /**
     * 加载仓库
     * @param product
     * @param times
     */
    public void preload(Product product, int times) {
        inventory.put(product.getName(), times);
    }

    /**
     * 结算时被购物车调用
     * @param productName
     * @param times
     */
    public void subtract(String productName, Integer times) {
        int now = inventory.get(productName);
        int after = now - times;
        if (after == 0) {
            inventory.remove(productName);
        } else {
            inventory.put(productName, after);
        }
        boxesMovedOut += times;
    }

    /**
     * 提供库存物品查询
     * @param productName
     * @return
     */
    public int availableOfProduct(String productName) {
        return inventory.getOrDefault(productName, 0);
    }

    /**
     * 空返回true
     * @return
     */
    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    /**
     * 售出货物跟踪
     * @return
     */
    public int getBoxesMovedToday() {
        return boxesMovedOut;
    }
}
