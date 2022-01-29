import spock.lang.Specification

/**
 * 测试数学运算
 */
class DataDrivenSpec extends Specification {

    def "测试获取两个数的最大值"() {
        expect:
        Math.max(a, b) == c

        where:
        a << [3, 5, 9]
        b << [7, 4, 9]
        c << [7, 5, 9]
    }

    def "测试获取两个数的最小值"() {
        expect:
        Math.min(a, b) == c

        where:
        a | b || c
        3 | 7 || 3
        5 | 4 || 4
        9 | 9 || 9
    }

    def "测试用户性别"() {
        expect:
        person.getSex() == sex

        where:
        person                    || sex
        new Person(name: "Fred")  || "Male"
        new Person(name: "Wilma") || "Female"
    }

    static class Person {
        String name
        String getSex() {
            name == "Fred" ? "Male" : "Female"
        }

    }


}
