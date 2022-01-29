import spock.lang.Specification


/**
 * 使用 then: 块来测试调用顺序
 */
class OrderInteractionsSpec extends Specification {

    def "测试方法调用顺序"() {
        def coll1 = Mock(Collaborator)
        def coll2 = Mock(Collaborator)

        when:
        coll1.collaborate()
        coll2.collaborate()

        then:
        1 * coll1.collaborate()

        then:
        1 * coll2.collaborate()
    }

}

interface Collaborator {
    def collaborate()
}