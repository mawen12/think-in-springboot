package com.mawen.demo.controller;

import com.mawen.demo.bean.BlogProperties;
import com.mawen.demo.bean.ConfigBean;
import com.mawen.demo.bean.TestConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author mawen
 * @since 2022/04/08
 */
@RestController
public class IndexController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private TestConfigBean testConfigBean;

    @RequestMapping("/")
    public String index() {
        return configBean.getName() + "," + testConfigBean.getAge() + "," + blogProperties.getTitle();
    }

}
