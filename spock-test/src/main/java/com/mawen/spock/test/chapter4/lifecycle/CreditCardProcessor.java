package com.mawen.spock.test.chapter4.lifecycle;

/**
 * 信用卡机器，用于充值信用卡
 *
 * @author mawen
 * @create 2022-02-08 14:15
 */
public class CreditCardProcessor {

    private int salesToday;

    public CreditCardProcessor() {
        System.out.println("Expensive Credit processor is starting");
        salesToday = 0;
    }

    public void newDayStarted() {
        salesToday = 0;
    }

    public void charge(int price) {
        salesToday += price;
    }

    public int getCurrentRevenue() {
        return salesToday;
    }

    public void shutDown() {
        System.out.println("Expensive Credit processor is stopping");
    }
}
