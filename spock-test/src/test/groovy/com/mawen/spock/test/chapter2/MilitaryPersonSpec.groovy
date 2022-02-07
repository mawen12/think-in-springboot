package com.mawen.spock.test.chapter2

import spock.lang.Specification


class MilitaryPersonSpec extends Specification {

    def "测试Java类的Setter/Getter方法"() {
        when: "具有姓名和级别的人员"
        def person = new MilitaryPerson()
        person.firstName = "Susan"
        person.lastName = "Ivanova"
        person.setRank("Commander")

        then: "校验姓名和级别"
        person.createTitle() == "Ivanova, Susan (Commander)"
    }

}