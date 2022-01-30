package com.mawen.spock.test.chapter1

import com.mawen.spock.test.chapter1.billing.Client
import com.mawen.spock.test.chapter1.billing.CreditCardBilling
import spock.lang.Specification

/**
 * 测试消费奖励展示
 */
class BetterSpec extends Specification {

    def "客户消费超过100刀可获额外奖励"() {
        when: "客户消费100刀以上"
        def client = new Client()
        def billing = new CreditCardBilling()
        billing.charge(client, 150)

        then: "激活奖励"
        client.hasBonus()
    }

    def "取消交易，奖励失效"() {
        when: "客户消费超过100刀，但是最终改变了想法，取消交易"
        def client = new Client()
        def billing = new CreditCardBilling()
        billing.charge(client, 150)
        client.rejectsCharge()

        then: "奖励失效"
        !client.hasBonus()
    }

}