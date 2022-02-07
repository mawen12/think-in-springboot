package com.mawen.spock.test.chapter2

import spock.lang.Ignore
import spock.lang.Specification

/**
 * Spock 失败演示
 */
@Ignore
class PowerAssertSpec extends Specification {

    def "Spock 断言 数字"() {
        expect:
        (4 * 15) - (24 / 3) == (2 * 30) - 9
    }

    def "Spock 断言字符串"() {
        when:
        String quote = "Please scan Abbut. Report to me his thoughts at present"

        then:
        quote == "Please scan Abut. Report to me his thoughts at present"
    }

    def "Spock 断言集合"() {
        when:
        List<String> all = ["Vorlon","Shadows","Minbari", "Humans","Drazi"]
        List<String> firstOnes = ["Vorlon","Shadows"]

        then:
        all.subList(0, all.indexOf("Humans")) == firstOnes
    }

    def "Spock 断言方法调用"() {
        when:
        String text = "They are alone. They are a dying race."
        def wordDetector = new WordDetector()

        then:
        wordDetector.feedText(text).duplicatesFound().size() == 5
    }

}