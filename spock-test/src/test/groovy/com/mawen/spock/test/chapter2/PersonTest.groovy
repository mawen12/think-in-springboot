package com.mawen.spock.test.chapter2

import spock.lang.Specification

class PersonTest extends Specification {

    def "测试创建用户，打印用户信息"() {
        def person = new Person()
        person.firstName = "Susan"
        person.lastName = ""
    }


}
