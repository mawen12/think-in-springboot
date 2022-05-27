# Component-Scan


## 1.问题描述

在Spring Boot应用启动时，会去扫描并注册@Component组件。那么它是如何扫描的呢？

### 问题分析

上述问题的核心点在于：
    - 如何确定扫描的路径？
    - 如何确定路径的中文件就是要找的@Component组件？

### 如何确定扫描的路径？

默认情况：
@Component组件默认的扫描路径是由@SpringBootApplication注解的类所在包的路径。(详见：org.springframework.context.annotation.ComponentScanAnnotationParser.parse)
例如 Application 所在的包是：com.mawen.think.in.springboot
那么读取的类的正则是：classpath*:com/mawen/think/in/springboot/**/*.class(详见：org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider.scanCandidateComponents)

自定义：
在@SpringBootApplication注解中，使用了元注解@ComponentScan，并通过@AliasFor设置属性别名，实现值得共享。
设置@SpringBootApplication#scanBasePackages或者@ComponentScan#basePackages指定要扫描得包路径。
如果使用自定义得话，不能忘记显示指定MainClass所在得包。

### 如何确定路径下的文件就是要找的@Component组件？

在确定了要扫描得包路径后，会将扫描得逻辑委托给 ClassPathBeanDefinitionScanner#doScan 方法，
在该类中，使用了 findCandidateComponents 来扫描指定路径下使用了 @Component 或 @ManagedBean 的类。

## 2.问题描述

针对一个 Bean，设置了一个参数，然后设置对应的参数构造器。此时时启动报错：
Parameter 0 of constructor in com.mawen.think.in.controller.ServiceImpl required a bean of type 'java.lang.String' that could not be found.

### 问题分析

