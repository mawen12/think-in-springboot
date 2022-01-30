package com.mawen.spock.test.chapter1

import spock.lang.Specification

class AdderSpec extends Specification {

    def "返回两数之和"() {
        when: "创建 Adder 类"
        def adder = new Adder()

        then: "1 + 1 = 2"
        adder.add(1, 1) == 2
    }

    def "两个数顺序不影响结果"() {
        when: "创建 Adder 类"
        def adder = new Adder()

        then: "2 + 3 = 5"
        adder.add(2, 3) == 5

        then: "3 + 2 = 5"
        adder.add(3, 2) == 5
    }
}
