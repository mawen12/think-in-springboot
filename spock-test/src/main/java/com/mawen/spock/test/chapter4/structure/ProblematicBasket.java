package com.mawen.spock.test.chapter4.structure;

import com.mawen.spock.test.chapter4.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mawen
 * @create 2022-02-08 14:44
 */
public class ProblematicBasket {

    protected Map<Product, Integer> contents = new HashMap<>();

    public void clearAllProducts(){
        contents.clear();
    }

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

    public int getCurrentWeight() {
        int total = 0;
        for (Map.Entry<Product, Integer> entry : contents.entrySet()) {
            total += entry.getKey().getWeight() * entry.getValue();
        }
        return total;
    }

    public int getProductTypesCount() {
        return contents.size();
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("[ ");
        for (Map.Entry<Product, Integer> entry:contents.entrySet())
        {
            builder.append(entry.getValue());
            builder.append(" x ");
            builder.append(entry.getKey().getName());
            builder.append(", ");
        }
        builder.setLength(builder.length()-2);

        return builder.append(" ]").toString();
    }
}
