package com.example.demo.controller.aop;

import org.springframework.stereotype.Component;

/**
 * Created by xuwencong on 2018/8/13
 */
@Component
public class TargetClass {

    /**
     * 拼接两个字符串
     */
    public String joint(String str1, String str2) {
        return str1 + "+" + str2;
    }
}
