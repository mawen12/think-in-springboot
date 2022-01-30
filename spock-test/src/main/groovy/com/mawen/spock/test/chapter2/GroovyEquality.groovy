package com.mawen.spock.test.chapter2

String first = "First"
String second = "Second"

List<String> sample = new ArrayList<>()
sample.add(first)
sample.add(second)

List<String> sample2 = new ArrayList<>()
println "Result is " + (sample == sample2)

