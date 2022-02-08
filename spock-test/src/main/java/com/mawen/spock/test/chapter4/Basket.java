package com.mawen.spock.test.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * 购物车
 *
 * @author mawen
 * @create 2022-02-08 10:30
 */
public class Basket {

    protected Map<Product, Integer> contents = new HashMap<>();

    /**
     * 清空购物车
     */
    public void clearAllProducts() {
        contents.clear();
        System.out.println("clear the basket");
    }

    /**
     * 添加产品
     * @param product
     */
    public void addProduct(Product product) {
        addProduct(product, 1);
    }

    public void addProduct(Product product, int times) {
        if (contents.containsKey(product)) {
            int existing = contents.get(product);
            contents.put(product, existing + times);
        } else {
            contents.put(product, times);
        }
    }

    /**
     * 计重
     * @return
     */
    public int getCurrentWeight() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : contents.entrySet()) {
            total += entry.getKey().getWeight() * entry.getValue();
        }
        return total;
    }

    /**
     * 计算产品种类
     * @return
     */
    public int getProductTypesCount() {
        return contents.size();
    }

}
