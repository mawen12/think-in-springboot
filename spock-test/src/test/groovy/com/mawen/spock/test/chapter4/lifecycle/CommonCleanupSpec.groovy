package com.mawen.spock.test.chapter4.lifecycle

import com.mawen.spock.test.chapter4.Basket
import com.mawen.spock.test.chapter4.Product
import spock.lang.Specification
import spock.lang.Subject


@Subject(Basket)
class CommonCleanupSpec extends Specification {
    /**
     * 共同变量转为字段
     */
    Product tv
    Product camera
    Basket basket

    /**
     * 声明周期函数
     * 每个测试方法执行前自动执行
     */
    def setup() {
        tv = new Product(name:"bravia",price:1200,weight:18)
        camera = new Product(name:"panasonic",price:350,weight:2)
        basket = new Basket()
    }

    def "A basket with one product weights as that product"() {
        when: "user wants to buy the TV"
        basket.addProduct tv

        then: "basket weight is euqal to all product weight"
        basket.currentWeight == tv.weight
    }

    def "A basket with two products as their sum"() {
        when: "user wants to buy the TV and the camera"
        basket.addProduct tv
        basket.addProduct camera

        then: "basket weight is equal to all product weight"
        basket.currentWeight == (tv.weight + camera.weight)
    }

    /**
     * 声明生命周期函数
     * 每个测试方法执行后自动执行
     */
    def cleanup() {
        basket.clearAllProducts()
    }

}