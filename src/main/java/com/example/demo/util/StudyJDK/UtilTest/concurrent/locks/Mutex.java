package com.example.demo.util.StudyJDK.UtilTest.concurrent.locks;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @program: demo
 * @description:
 *
 * AbstractQueuedSynchronizer的一个测试用例，写的不好
 *
 *
 * 独占模式 并且不支持重入的 lock
 * @author: youyi
 * @create: 2019-11-08 14:38
 **/
public class Mutex implements Lock, Serializable {

    // 同步队列
    private final Sync sync = new Sync();


    @Override
    public void lock() {
        sync.acquire(1);
    }
    // 支持中断式的获取 lock
    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }
    // 尝试获取 lock
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    // 具体同步队列实现
    static class Sync extends AbstractQueuedSynchronizer {
        // report whether in locked state
        protected boolean inHeldExclusively(){ // 判断 lock 是否被占用
            return getState() == 1;
        }
        // 获取 lock
        // Acquire the lock if state is zero
        public boolean tryAcquire(int acquires){
            assert acquires == 1; // Otherwise unsed
            if(compareAndSetState(0, 1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }
        // 释放 lock
        // Releses the lock by setting state to zero
        protected boolean tryRelease(int release){
            assert release == 1; // Otherwise unused
            if(getState() == 0){
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        // Provides a Condition
        Condition newCondition(){
            return new ConditionObject();
        }

        // Deserializes properly
        private void readObject(ObjectInputStream s)throws IOException, ClassNotFoundException{
            s.defaultReadObject();
            setState(0); // reset to unlocked state
        }

    }

    public static void main(String[] args) {
        String a = "youyi";
        Mutex lock = new Mutex();
        lock.lock();
        a = "hhh";
        System.out.println(a);
        lock.unlock();
    }
}
