package com.mawen.spock.test.chapter2

import spock.lang.Specification


class ExpandoDemoSpec extends Specification {

    def "测试无效地址"() {
        when: "一个没有邮编的地址"
        Address address = new Address(country: "Greece", number: 23)

        def dummyAddressDao = new Expando()
        dummyAddressDao.load = {return address}

        def stamper = new Stamper(dummyAddressDao as AddressDao)

        then: "该地址非法"
        !stamper.isValid(1)
    }

    def "测试有效和无效地址"() {
        when: "校验两个不同的地址"
        def invalidAddress = new Address(country: "Greece", number: 23)
        def validAddress = new Address(country: "Greece", number: 23, street: "Argous", postCode: "4534")

        def dummyAddressDao = new Expando()
        dummyAddressDao.load = {id -> return id == 2 ? validAddress : invalidAddress}

        def stamper = new Stamper(dummyAddressDao as AddressDao)

        then: "只有具有街道和邮编的地址才是正确的"
        !stamper.isValid(1);
        stamper.isValid(2)
    }


}