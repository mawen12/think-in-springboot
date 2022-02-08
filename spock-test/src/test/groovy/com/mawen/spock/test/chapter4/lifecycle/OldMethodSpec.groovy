package com.mawen.spock.test.chapter4.lifecycle

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Title


@Title("Unit test for old")
class OldMethodSpec extends Specification {

    def "Adding a second product to the basket increases its weight"() {
        given: "an empty basket"
        def basket = new Basket()

        and: "a tv is already added to the basket"
        def tv = new Product(name: "bravia", price: 1200, weight: 18)
        basket.addProduct(tv)

        when: "user gets a camera too"
        def camera = new Product(name: "panasonic", price: 350, weight: 2)
        basket.addProduct(camera)

        then: "basket weight is updated accordingly"
        basket.currentWeight == old(basket.currentWeight) + camera.weight // old 方法用来获取之前的值
    }

}