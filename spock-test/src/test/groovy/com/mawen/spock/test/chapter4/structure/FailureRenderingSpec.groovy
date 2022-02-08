package com.mawen.spock.test.chapter4.structure

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification

class FailureRenderingSpec extends Specification {

    def "Adding products to a basket increases its weight"() {
        given: "an empty basket"
        def basket = new ProblematicBasket()

        and: "two difference products"
        Product laptop = new Product(name:"toshiba",price:1200,weight:5)
        Product camera = new Product(name:"panasonic",price:350,weight:2)

        when: "user gets a laptop and two cameras"
        basket.addProduct laptop
        basket.addProduct(camera, 2)

        then: "basket weight is updated accordingly"
        basket.currentWeight == (2 * camera.weight) + laptop.weight
    }


}
