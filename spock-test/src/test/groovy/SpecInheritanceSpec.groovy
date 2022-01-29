import spock.lang.Specification

/**
 * 子父级的Spec 执行顺序：
 * (p)setupSpec -> setupSpec -> (p)field -> field -> (p)setup -> setup -> cleanup -> (p)cleanup -> cleanupSepc() -> (f)cleanupSpec()
 */
abstract class BaseSpec extends Specification {

    def x = { println 'base field initializer' }() // ②

    def setupSpec() { println 'base setupSpec()' } // ①

    def cleanupSpec() { println 'base cleanupSpec()' } // ⑥

    def setup() { println 'base setup()' } // ③

    def cleanup() { println 'base cleanup()' } // ⑤

    def baseSpecMethod() {
        setup:
        println 'base spec method'
    } // ④
}


class DerivedSpec extends BaseSpec {
    def y = { println 'derived field initializer' } // ②

    def setupSpec() { println 'derived setupSpec()'} // ①

    def cleanupSpec() { println 'derived cleanupSpec()'}

    def setup() { println 'derived setup()' }

    def cleanup() { println 'derived cleanup()' }

    def baseSpecMethod() {
        setup:
        println 'derived spec method'
    } // ④
}