package com.mawen.spock.test.chapter2

import spock.lang.Specification


class GroovyClosureSpec extends Specification {

    def "测试图片文件"() {
        when: "只有jpeg后缀的文件才可以被选择"
        def myFilter = new FileExtensionFilter()
        myFilter.addValidExtension("jpeg")
        myFilter.addValidExtension("jpg")

        List<String> testInput = ["image1.jpg","image2.png","image3.jpeg","image4.gif","image5.jpg","image6.tiff"]
        List<String> result = myFilter.filterFileNames(testInput)

        then: "结果不能包含其他格式文件"
        result.every(fileName -> fileName.endsWith("jpeg") || fileName.endsWith("jpg"))
    }


}