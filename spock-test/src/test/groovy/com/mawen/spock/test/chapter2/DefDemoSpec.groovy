package com.mawen.spock.test.chapter2

import spock.lang.Specification


class DefDemoSpec extends Specification {

    public void trivialSum1() {
        when: "数字1"
        int number = 1

        then: "数字相加是2"
        number + number == 2
    }

    def trivialSum2() {
        when: "数字1"
        int number = 1

        then: "数字相加是2"
        number + number == 2
    }

    def "测试数字相加"() {
        when: "数字1"
        int number = 1

        then: "数字相加是2"
        number + number == 2
    }


}