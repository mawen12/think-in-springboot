package com.mawen.demo;

import com.mawen.demo.bean.BlogProperties;
import com.mawen.demo.bean.ConfigBean;
import com.mawen.demo.bean.TestConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author mawen
 * @since 2022/04/08
 */
@SpringBootApplication
@EnableConfigurationProperties({TestConfigBean.class, ConfigBean.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
