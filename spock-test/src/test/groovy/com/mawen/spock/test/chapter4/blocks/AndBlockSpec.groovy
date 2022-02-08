package com.mawen.spock.test.chapter4.blocks

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Title

/**
 * and: 用来区分被测试主体和协作类，划分好块，提升可读性
 */
@Title("Unit test for and block")
class AndBlockSpec extends Specification {

    def "A basket with three products weight as their sum"() {
        given: "an empty basket" // 被测试对象初始化
        def basket = new Basket()

        and: "several products" // 协作类初始化
        def tv = new Product(name: "bravia", price: 1200, weight: 18)
        def camera = new Product(name: "panasonic", price: 350, weight: 2)
        def hifi = new Product(name: "jvc", price: 600, weight: 5)

        when: "user wants to buy the tv and the camera and the hifi"
        basket.addProduct(tv)
        basket.addProduct(camera)
        basket.addProduct(hifi)

        then: "basket weight is equal to all product weight"
        basket.currentWeight == (tv.weight + camera.weight + hifi.weight)
    }

    def "A basket with three products weights as their sum (alternate)"() {
        given: "an empty basket, a TV, a camera and a hifi"
        def basket = new Basket()
        def tv = new Product(name: "bravia", price: 1200, weight: 18)
        def camera = new Product(name: "panasonic", price: 350, weight: 2)
        def hifi = new Product(name: "jvc", price: 600, weight: 5)

        when: "user wants to buy the tv"
        basket.addProduct(tv)

        and: "user wants to buy the tv"
        basket.addProduct(camera)

        and: "user wants to buy the tv"
        basket.addProduct(hifi)

        then: "basket weight is equal to all product weight"
        basket.currentWeight == (tv.weight + camera.weight + hifi.weight)
    }

    def "A basket with three products has correct weight and count (controversial)"() {
        given: "an empty basket, a TV,a camera and a hifi"
        Basket basket = new Basket()
        Product tv = new Product(name: "bravia", price: 1200, weight: 18)
        Product camera = new Product(name: "panasonic", price: 350, weight: 2)
        Product hifi = new Product(name: "jvc", price: 600, weight: 5)

        when: "user wants to buy the TV and the camera and the hifi"
        basket.addProduct tv
        basket.addProduct camera
        basket.addProduct hifi

        then: "the basket weight is equal to all product weights"
        basket.currentWeight == (tv.weight + camera.weight + hifi.weight)

        and: "it contains 3 products"
        basket.productTypesCount == 3
    }

}