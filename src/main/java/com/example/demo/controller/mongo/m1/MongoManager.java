package com.example.demo.controller.mongo.m1;

import com.mongodb.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuwencong on 2018/8/10
 */
public class MongoManager {

    private static Mongo mongo;
    private DB db;


    static{
        init();
    }

    /**
     * @param dbName
     * @param userName
     * @param pwd
     * 实例化dbName一个DB
     */
    public MongoManager(String dbName, String userName, String pwd) {
        if (dbName == null || "".equals(dbName)) {
            throw new NumberFormatException("dbName is null");
        }
        db = mongo.getDB(dbName);
        if(MongoConfig.isAuthentication()){
            if (userName == null || "".equals(userName)) {
                throw new NumberFormatException("userName is null");
            }
            if (pwd == null || "".equals(pwd)) {
                throw new NumberFormatException("pwd is null");
            }
//            db.authenticate(userName, pwd.toCharArray());
        }
    }

    /**
     * 使用配置参数实例化
     */
    public MongoManager() {
        this(MongoConfig.getDbName(), MongoConfig.getUserName(), MongoConfig.getPwd());
    }

    /**
     * @param tableName
     * @return
     * @Date:2014-3-19
     * @Author:lulei
     * @Description: 获取表tableName的链接DBCollection
     */
    public DBCollection getDBCollection(String tableName) {
        return db.getCollection(tableName);
    }

    /**
     * @Date:2014-3-19
     * @Author:lulei
     * @Description: mongo连接池初始化
     */
    private static void init() {
        if (MongoConfig.getHost() == null || MongoConfig.getHost().length == 0) {
            throw new NumberFormatException("host is null");
        }
        if (MongoConfig.getPort() == null || MongoConfig.getPort().length == 0) {
            throw new NumberFormatException("port is null");
        }
        if (MongoConfig.getHost().length != MongoConfig.getPort().length) {
            throw new NumberFormatException("host's length is not equals port's length");
        }
        try {
            //服务列表
            List<ServerAddress> replicaSetSeeds = new ArrayList<>();
            for (int i = 0; i < MongoConfig.getHost().length; i++) {
                replicaSetSeeds.add(new ServerAddress(MongoConfig.getHost()[i], MongoConfig.getPort()[i]));
            }
            //连接池参数设置
            MongoOptions options = new MongoOptions();
            options.connectionsPerHost = MongoConfig.getConnectionsPerHost();
            options.threadsAllowedToBlockForConnectionMultiplier = MongoConfig.getThreadsAllowedToBlockForConnectionMultiplier();
            mongo = new Mongo(replicaSetSeeds, options);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
