package com.mawen.spock.test.chapter4.blocks

import spock.lang.Specification
import spock.lang.Title


@Title("Unit Test with no block")
class NoBlockSpec extends Specification {

    def "Invalid Spock test"() {
        int a = 5
        a == 6
    }


}