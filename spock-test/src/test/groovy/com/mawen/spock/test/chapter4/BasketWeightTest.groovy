package com.mawen.spock.test.chapter4

import spock.lang.Narrative
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Title

@Narrative(""" A empty basket starts with no weight. Adding products to the basket
increases its weight. The weight is then used for billing during shipping calculations.
Electronic goods have always 0 weight.
""") // 多行文本
@Title("Unit test for basket weight") // 弥补无法支持类名自然语言化
class BasketWeightTest extends Specification {

    def "A basket with two products as their sum"() {
        given: "an empty basket"
        @Subject
        def basket = new Basket() // 主体

        and: "several products"
        def tv = new Product(name: "bravia", price: 1200, weight: 18)
        def camera = new Product(name: "panasonic", price: 350, weight: 2)

        when: "user want to buy the TV and camera and the hifi"
        basket.addProduct(tv)
        basket.addProduct(camera)

        then: "basket weight is equal to all product weight"
        basket.currentWeight == (tv.weight + camera.weight)
    }





}
