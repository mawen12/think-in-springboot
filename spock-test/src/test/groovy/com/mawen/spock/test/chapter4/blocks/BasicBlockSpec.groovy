package com.mawen.spock.test.chapter4.blocks

import spock.lang.Specification
import spock.lang.Title


@Title("Unit test for basic block")
class BasicBlockSpec extends Specification {

    def "Adding two and three results in 5"() {
        given: "the integers two and three"
        int a = 3;
        int b = 2

        when: "they are added"
        int result = a + b

        then: "the result is 5"
        result == 5
    }

}