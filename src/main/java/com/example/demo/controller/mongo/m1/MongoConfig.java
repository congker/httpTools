package com.example.demo.controller.mongo.m1;

import lombok.Data;

/**
 * Created by xuwencong on 2018/8/10
 */
public class MongoConfig {

    private static String userName;//用户名
    private static String pwd;//密码
    private static String[] host;//主机地址
    private static int[] port;//端口地址
    private static String dbName;//数据库名
    private static int connectionsPerHost = 20;//每台主机最大连接数
    private static int threadsAllowedToBlockForConnectionMultiplier = 10;//线程队列数
    private static boolean authentication = false;//是否需要身份验证

    static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        MongoConfig.userName = userName;
    }

    static String getPwd() {
        return pwd;
    }

    public static void setPwd(String pwd) {
        MongoConfig.pwd = pwd;
    }

    static String[] getHost() {
        return host;
    }

    static void setHost(String[] host) {
        MongoConfig.host = host;
    }

    static int[] getPort() {
        return port;
    }

    static void setPort(int[] port) {
        MongoConfig.port = port;
    }

    static String getDbName() {
        return dbName;
    }

    static void setDbName(String dbName) {
        MongoConfig.dbName = dbName;
    }

    static int getConnectionsPerHost() {
        return connectionsPerHost;
    }

    public static void setConnectionsPerHost(int connectionsPerHost) {
        MongoConfig.connectionsPerHost = connectionsPerHost;
    }

    static int getThreadsAllowedToBlockForConnectionMultiplier() {
        return threadsAllowedToBlockForConnectionMultiplier;
    }

    public static void setThreadsAllowedToBlockForConnectionMultiplier(int threadsAllowedToBlockForConnectionMultiplier) {
        MongoConfig.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
    }

    static boolean isAuthentication() {
        return authentication;
    }

    public static void setAuthentication(boolean authentication) {
        MongoConfig.authentication = authentication;
    }
}
