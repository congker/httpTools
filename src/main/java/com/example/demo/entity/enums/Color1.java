package com.example.demo.entity.enums;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xuwencong on 2018/8/16
 */
public enum Color1 {

    RED(200, ""),
    BLUE(300, ""),
    GREEN(400, "");//注意此处必须有分号

    private int code;
    private String message;
    private static final Map<Integer,Color1> lookup =new HashMap<>();

    private Color1(int code, String message){
        this.code = code;
        this.message = message;
    }
    static {
            for (Color1 item:Color1.values()){
                lookup.put(item.getCode(),item);
            }
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Color1 getLookup(Integer Code) {
        return lookup.get(Code);
    }
}
