package com.mawen.spock.test.chapter2;

import java.util.*;

/**
 * 单词文本计数器
 *
 * @author mawen
 * @create 2022-01-30 10:23
 */
public class WordDetector {

    private Map<String, Integer> countPerWord = new HashMap<>();

    public void parseText(String text) {
        countPerWord.clear();
        feedText(text);
    }

    public WordDetector feedText(String text) {
        String[] words = text.split("[\\s,;]"); // 仅用于说明的代码
        Arrays.stream(words).forEach(this::recordCount);
        return this;
    }

    private void recordCount(String word) {
        if (!countPerWord.containsKey(word)) {
            countPerWord.put(word, 0);
        }
        int now = countPerWord.get(word);
        countPerWord.put(word, now + 1);
    }

    public int wordsFound() {
        return countPerWord.size();
    }

    public Collection<String> duplicatesFound() {
        List<String> result = new ArrayList<>();

        countPerWord.forEach((key, count) -> {
            if (count > 1) {
                result.add(key);
            }
        });
        return result;
    }


}
