package com.mawen.spock.test.chapter2

List<String> all = ["Vorlon", "Shadows", "Minbari", "Humans", "Drazi"]
List<String> firstOnes = ["Vorlon", "Shadows"]

String text = "They are alone, They are a dying race."
WordDetector wordDetector = new WordDetector();

assert wordDetector.feedText(text).duplicatesFound().size() == 2
