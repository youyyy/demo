package com.example.demo.util.StudyJDK.UtilTest.concurrent.locks;


import java.util.concurrent.Semaphore;

/**
 * 信号量机制的使用
 */
public class SemaphoreTest {
    private int times;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public SemaphoreTest(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        SemaphoreTest printABC = new SemaphoreTest(10);
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
    }

    public void printA() {
        try {
            print("A", semaphoreA, semaphoreB);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printB() {
        try {
            print("B", semaphoreB, semaphoreC);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void printC() {
        try {
            print("C", semaphoreC, semaphoreA);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void print(String name, Semaphore current, Semaphore next)
            throws InterruptedException {
        for (int i = 0; i < times; i++) {
            current.acquire();
            System.out.print(name);
            next.release();
        }
    }
}