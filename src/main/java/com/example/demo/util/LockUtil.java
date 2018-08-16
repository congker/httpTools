package com.example.demo.util;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xuwencong on 2018/8/6
 */
public class LockUtil {
    private ArrayList<String> arrayList = new ArrayList<>();
    Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final LockUtil test = new LockUtil();
        for (int i = 0; i < 3; i++) {

            final Integer count=i;
            new Thread("甲"){
                public void run() {
                test.insert(Thread.currentThread(),count);
            };}.start();
            new Thread("乙"){public void run() {
                test.insert(Thread.currentThread(),count);
            };}.start();

        }
        test.arrayList.forEach(e->{
            System.out.println(e);
        });
    }

    private void insert(Thread thread,Integer count) {

        lock.lock();
        try {
            //线程获取到了锁
            for (int i = 0; i<5; i++) {
                arrayList.add("第"+count+"次"+"线程"+thread.getName()+i);
            }
        } catch(Exception e) {
           e.printStackTrace();
        }finally {
            //线程释放锁
            lock.unlock();
        }
    }

}
