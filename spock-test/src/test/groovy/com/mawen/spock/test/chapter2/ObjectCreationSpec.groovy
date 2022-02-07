package com.mawen.spock.test.chapter2

import spock.lang.Specification


class ObjectCreationSpec extends Specification {

    def "快速构造器"() {
        when:
        def trainee = new Employee(age: 22, firstName: "Alice", lastName: "Olson", inTraining: true)
        def seasoned = new Employee(middleName: "Jones", lastName: "Corwin", age: 45, firstName: "Alex")

        def people = Arrays.asList(trainee, seasoned)

        def department = new Department()
        department.assign(people)

        then:
        department.manpowerCount() == 2
    }

    def "快速构造器及集合"() {
        when:
        List<Employee> people = [
                new Employee(age: 22, firstName: "Alice", lastName: "Olson", inTraining: true),
                new Employee(middleName: "Jones", lastName: "Corwin", age: 45, firstName: "Alex")
        ]

        def department = new Department()
        department.assign(people)

        then:
        department.manpowerCount() == 2
    }

}