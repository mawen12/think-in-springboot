package com.mawen.spock.test.chapter1.billing;

/**
 * 客户端
 *
 * @author mawen
 * @create 2022-01-29 14:38
 */
public class Client {

    private boolean bonus;

    public boolean hasBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public void rejectsCharge() {
        bonus = false;
    }
}
