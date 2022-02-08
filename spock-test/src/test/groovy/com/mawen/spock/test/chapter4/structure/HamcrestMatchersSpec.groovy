package com.mawen.spock.test.chapter4.structure

import spock.lang.Specification

import static org.hamcrest.CoreMatchers.hasItem
import static org.hamcrest.CoreMatchers.not
import static spock.util.matcher.HamcrestSupport.expect
import static spock.util.matcher.HamcrestSupport.that


class HamcrestMatchersSpec extends Specification {

    def "trivial test with Hamcrest"() {
        given: "a list of products"
        List<String> products = ["camera", "laptop", "hifi"]

        expect: "camera should be one of theme"
        products hasItem("camera")

        and: "hotdog is not one of theme"
        products not(hasItem("hotdog"))
    }

    def "trivial test with Hamcrest (alt)"() {
        given: "an empty list"
        List<String> products = new ArrayList<>()

        when: "it is filled with products"
        products.add "laptop"
        products.add "camera"
        products.add "hifi"

        then: "camera should be one of them"
        expect(products, hasItem("camera"))

        and: "hotdog is not one of them"
        that(products, not(hasItem("hotdog")))
    }

    def "trivial test with Groovy closure"() {
        given: "a list of products"
        List<String> products = ["camera", "laptop", "hifi"]

        expect: "camera should be one of them"
        products.any{productName -> productName == "camera"  }

        and: "hotdog is not one of them"
        products.every{ productName -> productName != "hotdog" }
    }




}