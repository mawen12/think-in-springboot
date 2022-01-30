package com.mawen.spock.test.chapter1

import spock.lang.Specification

class MultiplierTest extends Specification {

    def "返回两数乘积"(){
        when: "创建 Multiplier 类"
        def multi = new Multiplier()

        then: "3 * 7 = 21"
        multi.multiply(3, 7) == 21
    }

    def "乘和加组合"() {
        when: "创建 Multiplier 和 Adder 类"
        def adder = new Adder()
        def multi = new Multiplier()

        then: "4 * (2 + 3) = 20"
        multi.multiply(4, adder.add(2, 3)) == 20

        and: "(2 + 3) * 4 = 20"
        multi.multiply(adder.add(2, 3), 4) == 20
    }


}
