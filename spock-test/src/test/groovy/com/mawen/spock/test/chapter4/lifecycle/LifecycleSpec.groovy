package com.mawen.spock.test.chapter4.lifecycle

import spock.lang.Specification

/**
 * 生命周期顺序：setupSpec -> [+setup -> def -> cleanup] -> cleanupSpec
 */
class LifecycleSpec extends Specification {

    def setupSpec() { // 耗时长的初始化
        println "Will run only once"
    }

    def setup() { // 通用初始化
        println "Will run before EACH feature"
    }

    def "first feature being tested"() {
        expect: "trivial test"
        println "first feature runs"
        2 == 1 + 1
    }

    def "second feature being tesed"() {
        expect: "trivial test"
        println "second feature runs"
        5 == 3 + 2
    }

    def cleanup() { // 通用清理
        println "Will run to once after EACH feature"
    }

    def cleanupSpec() { // 耗时长的清理
        println "Will run once at the end"
    }


}