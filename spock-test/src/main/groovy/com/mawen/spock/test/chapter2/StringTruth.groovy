package com.mawen.spock.test.chapter2

String stringComingFromDb = "Susan"
assert stringComingFromDb

stringComingFromDb = "true"
assert stringComingFromDb.toBoolean()

stringComingFromDb = "1"
assert stringComingFromDb.toBoolean()

stringComingFromDb = "0"
assert !stringComingFromDb.toBoolean()

stringComingFromDb = "someThingElse"
assert !stringComingFromDb.toBoolean()
