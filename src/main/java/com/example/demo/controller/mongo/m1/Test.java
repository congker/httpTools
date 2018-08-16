package com.example.demo.controller.mongo.m1;

import com.mongodb.DBCollection;

/**
 * Created by xuwencong on 2018/8/10
 */
public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] host = {"47.98.137.227"};
        int[] port = {27017};
        MongoConfig.setHost(host);
        MongoConfig.setPort(port);
        MongoConfig.setDbName("myDB");
        MongoManager mongoManager = new MongoManager();
        DBCollection dbCollection= mongoManager.getDBCollection("chapter");
        System.out.println("res:"+dbCollection);
    }


}
