import spock.lang.Specification
import spock.lang.Stepwise

/**
 * {@code @Stepwise} 可以用来指定流程，使用该注解的时候，会强制从上往下执行。
 * 如果中间有expect结果为{@literal false}，则不会往下执行
 *
 * {@code @Stepwise} 可以使得方法具有逻辑依赖性，在更高级别的规范特别有用
 */
@Stepwise
class StepwiseExtensionSpec extends Specification {

    def "step 1"() {
        expect: true
    }

    def "step 2"() {
        expect: true
    }

    def "step 3"() {
        expect: true
    }
}
