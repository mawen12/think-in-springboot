package com.mawen.spock.test.chapter4.blocks

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Title

/**
 * cleanup: 类似于 try-catch-finally 中的finally块，主要用于在then执行后释放资源，即使then块出现异常，也会执行cleanup块
 */
@Title("Unit test for cleanup block")
class CleanupBlockSpec extends Specification {

    def "A basket with one product has equal weight"() {
        given: "an empty basket and a TV"
        def basket = new Basket()
        def tv = new Product(name: "bravia", price: 1200, weight: 18)

        when: "user want to buy the tv"
        basket.addProduct(tv)

        then: "basket weight is equal to the tv"
        basket.currentWeight == tv.weight
        throw new IllegalArgumentException()

        cleanup: "refresh basket resources" // 释放资源
        basket.clearAllProducts()
    }

}