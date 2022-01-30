package com.mawen.spock.test.chapter1.billing;

/**
 * 信用卡账单
 *
 * @author mawen
 * @create 2022-01-29 14:40
 */
public class CreditCardBilling {

    public void charge(Client client, double amount) {
        client.setBonus(amount > 100);
    }

}
