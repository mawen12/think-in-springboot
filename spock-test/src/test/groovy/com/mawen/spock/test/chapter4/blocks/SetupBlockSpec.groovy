package com.mawen.spock.test.chapter4.blocks

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Title


@Title("Unit test for setup block")
class SetupBlockSpec extends Specification {

    def "A basket with one product has equal weight (alternative)"() {
        setup: "an empty basket and a TV"
        def tv = new Product(name: "bravia", price: 1200, weight: 18)
        def basket = new Basket()

        when: "user wants to buy the TV"
        basket.addProduct tv

        then: "basket weight is equal to the TV"
        basket.currentWeight == tv.weight
    }

}