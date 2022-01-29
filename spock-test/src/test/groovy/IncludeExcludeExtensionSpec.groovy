import spock.lang.Specification

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

/**
 * 使用包含(include)或排除(exclude)来指定执行方法
 * 运行时需要指定配置脚本的位置。
 *
 * 默认配置脚本的位置：
 *  - 在类路径下的：SpockConfig.groovy
 *  - 在文件系统 $user_home/.spock/SpockConfig.groovy
 *
 * 在运行时需要测试的话，可以在VM参数中加上以下内容：
 * - -Dspock.configuration=IncludeFastConfig.groovy 或
 * - -Dspock.configuration=ExcludeSlowConfig.groovy
 *
 * @see src/test/resources/ExcludeSlowConfig.groovy
 * @see src/test/resources/IncludeFastConfig.groovy
 */
class IncludeExcludeExtensionSpec extends Specification {
    @Fast
    def "fast 方法"() {
        println "fast"
        expect: true
    }

    @Slow
    def "slow 方法"() {
        println "slow"
        expect: true
    }

    def "既不包含fast，也不包含slow"() {
        println "neither fast nor slow"
        expect: true
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Fast {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Slow {}