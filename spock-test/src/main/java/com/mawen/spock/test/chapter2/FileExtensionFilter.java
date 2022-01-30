package com.mawen.spock.test.chapter2;

import java.util.*;

/**
 * 文件后缀过滤器
 *
 * @author mawen
 * @create 2022-01-30 9:27
 */
public class FileExtensionFilter {
    private Set<String> validExtensions = new HashSet<>();

    public void addValidExtension(String extension) {
        validExtensions.add(extension);
    }

    public Collection<String> filterFileNames(List<String> input) {
        List<String> result = new ArrayList<>();

        for (String fileName : input) {
            int extensionIndex = fileName.lastIndexOf(".");
            if (extensionIndex < 0) {
                continue;
            }
            String fileExtension = fileName.substring(extensionIndex + 1);
            if (validExtensions.contains(fileExtension)) {
                result.add(fileName);
            }
        }

        return result;
    }

}
