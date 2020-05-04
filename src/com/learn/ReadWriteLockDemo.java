package com.learn;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author hulinqi
 * @date 2020/4/16 --  19:42
 * @purpuse
 */
//模拟分布式缓存
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();  //缓存技术一般需要用volatile修饰
    private ReentrantReadWriteLock rtwLock = new ReentrantReadWriteLock();

    //write
    public void put(String key,Object value){
        rtwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在写入。。。");
            TimeUnit.MILLISECONDS.sleep(500);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+" 写入完成。。。");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rtwLock.writeLock().unlock();
        }
    }


    //read
    public void get(String key){
        rtwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+" 正在读取。。。");
            TimeUnit.MILLISECONDS.sleep(500);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+" 读取完成。。。");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rtwLock.readLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args){
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++ ){
            final int tempint = i;
              new Thread(()->{
                  myCache.put(tempint+" ",tempint+"");
              }, String.valueOf(i)).start();
          }

      for (int i = 0; i < 5; i++ ){
          final int tempint = i;
          new Thread(()->{
              myCache.get(tempint+" ");
            }, String.valueOf(i)).start();
        }
    }

    StringBuffer b = new StringBuffer();
    StringBuilder B1 = new StringBuilder();
}


/*======================在没用ReenTrantReadWriteLock前的运行结果====================
* 0 正在写入。。。
1 正在写入。。。
1 写入完成。。。
0 写入完成。。。
3 正在写入。。。
3 写入完成。。。
2 正在写入。。。
2 写入完成。。。
4 正在写入。。。
1 正在读取。。。
0 正在读取。。。
0 读取完成。。。
1 读取完成。。。
4 写入完成。。。
4 正在读取。。。
4 读取完成。。。
3 正在读取。。。
3 读取完成。。。
2 正在读取。。。
2 读取完成。。。
*
* ======================在用了ReenTrantReadWriteLock后的运行结果====================
0 正在写入。。。
0 写入完成。。。
1 正在写入。。。
1 写入完成。。。
2 正在写入。。。
2 写入完成。。。
3 正在写入。。。
3 写入完成。。。
4 正在写入。。。
4 写入完成。。。
0 正在读取。。。
1 正在读取。。。
2 正在读取。。。
3 正在读取。。。
4 正在读取。。。
3 读取完成。。。
0 读取完成。。。
2 读取完成。。。
1 读取完成。。。
4 读取完成。。。
*
*
* */