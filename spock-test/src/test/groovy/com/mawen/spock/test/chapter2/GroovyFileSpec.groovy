package com.mawen.spock.test.chapter2

import spock.lang.Specification

/**
 * 读取外部文件
 */
class GroovyFileSpec extends Specification {

    def "从文本文件读取内容"() {
        when: "处理一段内容"
        def detector = new WordDetector()
        String inputText = new File("src/test/resources/quotes.txt").text
        detector.parseText(inputText)

        then: "单词数量正确"
        detector.wordsFound() == 78
    }

    def "一行行读取文件"() {
        when: "处理一段内容"
        List<String> inputText = new File("src/test/resources/quotes.txt").readLines()
        def detector = new WordDetector()
        for (String line : inputText) {
            detector.feedText(line)
        }

        then: "单词数量正确"
        detector.wordsFound() == 78
    }

}