package com.mawen.spock.test.chapter4.lifecycle

import com.mawen.spock.test.chapter4.Product
import spock.lang.Shared
import spock.lang.Specification

class SharedSpec extends Specification {

    @Shared
    CreditCardProcessor creditCardProcessor // 只会被创建一次

    BillableBasket basket // 被创建多次

    def setupSpec() {
        creditCardProcessor = new CreditCardProcessor()
    }

    def setup() {
        basket = new BillableBasket()
        creditCardProcessor.newDayStarted()
        basket.setCreditCardProcessor(creditCardProcessor)
    }

    def "user buys a single product"() {
        given: "an empty basket and a TV"
        def tv = new Product(name: "barvia", price: 1200, weight: 18)

        and: "user wants to buy the tv"
        basket.addProduct tv

        when: "user checks out"
        basket.checkout()

        then: "revenue is the same as the price of TV"
        creditCardProcessor.currentRevenue == tv.price
    }

    def "user buys two products"() {
        given: "an empty basket and a camera"
        def camera = new Product(name: "panasonic", price: 350, weight: 2)

        and: "user wants to two cameras"
        basket.addProduct(camera, 2)

        when: "user checks out"
        basket.checkout()

        then: "revenue is the same as the price of both products"
        creditCardProcessor.currentRevenue == 2 * camera.price
    }

    def cleanup() {
        basket.clearAllProducts()
    }

    def cleanupSpec() {
        creditCardProcessor.shutDown()
    }


}
