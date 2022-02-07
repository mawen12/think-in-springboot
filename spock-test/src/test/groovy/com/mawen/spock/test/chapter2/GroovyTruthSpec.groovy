package com.mawen.spock.test.chapter2

import spock.lang.Specification


class GroovyTruthSpec extends Specification {

    def "Groovy Truth"() {
        when: "处理一行文本"
        def wordDetector = new WordDetector()
        wordDetector.parseText("Understanding is a three edged sword: your side, their side, and the truth")

        then: "单词数量应该是正确的"
        wordDetector.wordsFound() > 0
        wordDetector.duplicatesFound().size() > 0

        wordDetector.wordsFound()
        wordDetector.duplicatesFound()
    }

    def "处理多行字符串"() {
        when: "处理一行文本"
        String input = '''I want you to know you were right. I didn't want \
			to admit that. Just pride I guess. You get my age, you get kinda set in your \
			ways. It had to be done. Don't blame yourself for what happened later.'''
        def wordDetector = new WordDetector()
        wordDetector.parseText(input)

        then: "单词数量应该是正确的"
        wordDetector.wordsFound() == 34
    }



}