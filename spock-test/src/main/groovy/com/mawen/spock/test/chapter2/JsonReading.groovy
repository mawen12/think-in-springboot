package com.mawen.spock.test.chapter2

import groovy.json.JsonSlurper

def jsonRoot = new JsonSlurper().parse(getClass().getClassLoader().getResourceAsStream("employee-data.json"))
assert jsonRoot.staff.department.name == "sales"
assert jsonRoot.staff.department.employee.size() == 2
assert jsonRoot.staff.department.employee[0].firstName == "Orlando"
assert jsonRoot.staff.department.employee[0].lastName == "Boren"
assert jsonRoot.staff.department.employee[0].age == "24"
assert jsonRoot.staff.department.employee[1].firstName == "Diana"
assert jsonRoot.staff.department.employee[1].lastName == "Colgan"
assert jsonRoot.staff.department.employee[1].age == "28"

