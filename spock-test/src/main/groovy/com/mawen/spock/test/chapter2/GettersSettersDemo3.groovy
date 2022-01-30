package com.mawen.spock.test.chapter2


class Person2{
    String firstName
    String lastName
    int age
    String rank
}

def person2 = new Person2()
person2.firstName = "Susan"
person2.lastName = "Ivanova"
person2.rank = "Commander"

println "Person first name is $person2.firstName"
println "Person last name is $person2.lastName"
println "Person rank is $person2.rank"