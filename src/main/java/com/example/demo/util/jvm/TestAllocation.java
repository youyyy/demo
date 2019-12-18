package com.example.demo.util.jvm;

/**
 * @program: demo
 * @description: 测试JVM内存分配
 *
 * 串行收集器：
 * DefNew：是使用-XX:+UseSerialGC（新生代，老年代都使用串行回收收集器）。
 * 并行收集器：
 * ParNew：是使用-XX:+UseParNewGC（新生代使用并行收集器，老年代使用串行回收收集器）或者-XX:+UseConcMarkSweepGC(新生代使用并行收集器，老年代使用CMS)。
 * PSYoungGen：是使用-XX:+UseParallelOldGC（新生代，老年代都使用并行回收收集器）或者-XX:+UseParallelGC（新生代使用并行回收收集器，老年代使用串行收集器）
 * garbage-first heap：是使用-XX:+UseG1GC（G1收集器）
 *
 * @author: youyi
 * @create: 2019-12-17 19:42
 **/
public class TestAllocation {
    private static final int _1m = 1024*1024;

    /**
     * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+UseSerialGC -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @param args
     */
    public static void main(String[] args) {
        fun();
//        fun2();

    }
    public static void fun(){
        byte[]  allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[2*_1m];
        allocation2 = new byte[2*_1m];
        allocation3 = new byte[2*_1m];
        allocation4 = new byte[4*_1m];
        /*
        [GC (Allocation Failure) [DefNew: 7388K->780K(9216K), 0.0034030 secs] 7388K->4876K(19456K), 0.0034346 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
Heap
 def new generation   total 9216K, used 7494K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  eden space 8192K,  81% used [0x00000007bec00000, 0x00000007bf28e880, 0x00000007bf400000)
  from space 1024K,  76% used [0x00000007bf500000, 0x00000007bf5c3208, 0x00000007bf600000)
  to   space 1024K,   0% used [0x00000007bf400000, 0x00000007bf400000, 0x00000007bf500000)
 tenured generation   total 10240K, used 4096K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
   the space 10240K,  40% used [0x00000007bf600000, 0x00000007bfa00020, 0x00000007bfa00200, 0x00000007c0000000)
 Metaspace       used 2987K, capacity 4556K, committed 4864K, reserved 1056768K
  class space    used 315K, capacity 392K, committed 512K, reserved 1048576K
         */
    }

    /**
     * -XX:PretenureSizeThreshold
     * PS收集器不识别
     */
    public static void fun2(){
        byte[]  allocation4 = new byte[4*_1m];

    }
}
