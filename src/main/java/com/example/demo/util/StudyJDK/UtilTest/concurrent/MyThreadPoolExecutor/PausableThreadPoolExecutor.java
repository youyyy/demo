//package com.example.demo.util.StudyJDK.UtilTest.concurrent.MyThreadPoolExecutor;
//
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * @program: demo
// * @description: description
// * @author: youyi
// * @create: 2019-11-21 15:03
// **/
//class PausableThreadPoolExecutor extends ThreadPoolExecutor {
//    private boolean isPaused;
//    private ReentrantLock pauseLock = new ReentrantLock();
//    private Condition unpaused = pauseLock.newCondition();
//
//    public PausableThreadPoolExecutor(...) {
//        super(...);
//    }
//
//    protected void beforeExecute(Thread t, Runnable r) {
//        super.beforeExecute(t, r);
//        pauseLock.lock();
//        try {
//            while (isPaused) unpaused.await();
//        } catch (InterruptedException ie) {
//            t.interrupt();
//        } finally {
//            pauseLock.unlock();
//        }
//    }
//
//    public void pause() {
//        pauseLock.lock();
//        try {
//            isPaused = true;
//        } finally {
//            pauseLock.unlock();
//        }
//    }
//
//    public void resume() {
//        pauseLock.lock();
//        try {
//            isPaused = false;
//            unpaused.signalAll();
//        } finally {
//            pauseLock.unlock();
//        }
//    }
//}
