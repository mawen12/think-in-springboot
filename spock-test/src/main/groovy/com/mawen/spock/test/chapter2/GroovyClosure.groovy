package com.mawen.spock.test.chapter2

Closure simple = { int x -> return x * 2 }
assert simple(3) == 6

def simpler = { x -> x * 2 }
assert simpler(3) == 6

def twoArguments = { x, y -> x + y }
assert twoArguments(3, 5) == 8
