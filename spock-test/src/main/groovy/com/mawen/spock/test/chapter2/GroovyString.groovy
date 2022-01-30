package com.mawen.spock.test.chapter2

class SimpleEmployee {
    String fullName
    int age
    SimpleDepartment department
}

class SimpleDepartment{
    String name;
    String location;
}

def sales = new SimpleDepartment(name: "Sales", location: "block C")
def employee = new SimpleEmployee(fullName: "Andrew Collins", age: 37, department: sales)

println "Age is $employee.age"
System.out.println("Age is " + employee.getAge())

println "Department location is at $employee.age"
System.out.println("Department location is at " + employee.getAge())

println "Person is adule ${employee.age > 18}"
println "Amount in dollars is \$300" // 转义符号
println "Person is adult ${employee.age > 18}"



