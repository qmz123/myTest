package com.ryit.servlet;

/**
 * Created by Remainder on 2020/3/11.
 */
public class Main {
    public static final String obj1 = "obj1";
    public static final String obj2 = "obj2";

    public static void main(String[] ars) {
        System.out.println("乔明子");
        new DeadLockA().start();
        new DeadLockB().start();
        System.out.println("xxxxx");
    }


}
class DeadLockA extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("LockA running");
            while(true){
                synchronized(Main.obj1){
                    System.out.println("LockA locked obj1");
                    //获取obj1后先等一会儿，让LockB有足够的时间锁住obj2
                    Thread.sleep(100);
                    System.out.println("LockA trying to lock obj2...");
                    synchronized(Main.obj2){
                        System.out.println("LockA locked obj2");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
class DeadLockB extends Thread {
    @Override
    public void run() {
        try{
            System.out.println("LockB running");
            while(true){
                synchronized(Main.obj2){
                    System.out.println("LockB locked obj2");
                    System.out.println("LockB trying to lock obj1...");
                    synchronized(Main.obj1){
                        System.out.println("LockB locked obj1");
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
