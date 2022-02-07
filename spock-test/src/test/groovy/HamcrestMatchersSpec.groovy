import spock.lang.Ignore
import spock.lang.Specification

/**
 * Hamcrest 匹配器与 Spock深度集成，语法为{@code <expected-value> <matcher>}。
 * 如果比较失败，则会输出条件和匹配器的信息
 */
@Ignore
class HamcrestMatchersSpec extends Specification {

    def "比较两个浮点数"() {
        def myPi = 3.14

        expect:
        myPi closeTo(Math.PI, 0.01)
    }

}