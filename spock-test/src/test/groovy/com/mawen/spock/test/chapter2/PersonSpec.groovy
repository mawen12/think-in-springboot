package com.mawen.spock.test.chapter2

import spock.lang.Specification

class PersonSpec extends Specification {

    def "测试创建用户，打印用户信息"() {
        when: "具有名称的人"
        def person = new SimplePerson()
        person.firstName = "Susan"
        person.lastName = "Ivanova"

        then: "标题应该等于名称的拼接"
        person.createTitle() == "Ivanova, Susan"
    }
}

class SimplePerson {
    String firstName;
    String lastName;

    String createTitle() {
        return "$lastName, $firstName"
    }
}
