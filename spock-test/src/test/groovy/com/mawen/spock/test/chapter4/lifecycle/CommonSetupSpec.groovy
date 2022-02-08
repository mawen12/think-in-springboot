package com.mawen.spock.test.chapter4.lifecycle

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Subject


@Subject(Basket)
class CommonSetupSpec extends Specification {

    Product tv
    Product camera

    def setup() {
        tv = new Product(name: "bravia", price: 1200, weight: 18)
        camera = new Product(name: "panasonic", price: 350, weight: 2)
    }

    def "A basket with one product weights as that product"() {
        given: "an empty basket"
        def basket = new Basket()

        when: "user wants to buy the TV"
        basket.addProduct tv

        then: "basket weight is equal to all product weight"
        basket.currentWeight == tv.weight
    }

    def "A basket with two products weight as their sum"() {
        given: "an empty basket"
        def basket = new Basket()

        when: "user wants to buy the TV and the camera"
        basket.addProduct tv
        basket.addProduct camera

        then: "basket weight is equal to all product weight"
        basket.currentWeight == (tv.weight + camera.weight)
    }

}