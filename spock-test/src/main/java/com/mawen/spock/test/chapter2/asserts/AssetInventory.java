package com.mawen.spock.test.chapter2.asserts;

import java.util.ArrayList;
import java.util.List;

/**
 * 组件库存
 *
 * @author mawen
 * @create 2022-01-30 11:58
 */
public class AssetInventory {
    private List<Ship> ships = new ArrayList<>();

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
