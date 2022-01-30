package com.mawen.spock.test.chapter2

import java.util.regex.Pattern

assert true
assert !false

assert true || false
assert true && !false

String firstName = "Susan"
assert firstName

def lastName = "Ivanova"
assert lastName

String empty = ""
assert !empty

def person = new Person()
assert person

Person nullReference = null
assert !nullReference

int answerToEverything = 42
assert answerToEverything

int zero = 0
assert !zero

Object[] array = new Object[3]
assert array

Object[] emptyArray = new Object[0]
assert !emptyArray

Pattern myRegex = ~/needle/
assert myRegex.matcher("needle in haystack")
assert !myRegex.matcher("Wrong haystack")

assert "needle in haystack" =~/needle/
assert !("Wrong haystack" =~/needle/)

def closure = {number -> number + 2}
assert closure

println "Script has finished because all asserts pass"

boolean flag = -42
assert flag




