package com.example.demo.controller;

import com.example.demo.entity.enums.Color;
import com.example.demo.entity.enums.Color1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xuwencong on 2018/7/31
 */
@RestController
@RequestMapping("web")
public class webController{

    @RequestMapping("/1")
    public String web(){

        return "web contoller";
    }

    public static void main(String[] args) {
        Color1 c=Color1.getLookup(200);
        switch (c){
            case RED:
                System.out.println("red");
                break;
            case BLUE:
                System.out.println("blue");
                break;
            case GREEN:
                System.out.println("green");
                break;
        }
    }

}
