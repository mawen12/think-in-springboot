import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

/**
 * 测试数据库SQL
 */
@Stepwise
class DatabaseDrivenSpec extends Specification {
    @Shared sql = Sql.newInstance("jdbc:h2:mem:", "org.h2.Driver")

    def setupSpec() {
        sql.execute("create table maxdata (id int primary key, a int, b int, c int)")
        sql.execute("insert into maxdata values (1, 3, 7, 7), (2, 5, 4, 5), (3, 9, 9, 9), (4, 2, -3, 2)")
    }

    def "测试 #a 和 #b 的最大值是 #c"() {
        expect:
        Math.max(a, b) == c

        where:
        [a, b, c] << sql.rows("select a, b, c from maxdata")
    }


}