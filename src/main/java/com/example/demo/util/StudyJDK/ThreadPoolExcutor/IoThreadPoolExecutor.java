package com.example.demo.util.StudyJDK.ThreadPoolExcutor;/*
          .--,       .--,
         ( (  \.---./  ) )
          '.__/o   o\__.'
             {=  ^  =}
              >  -  <
             /       \
            //       \\
           //|   .   |\\
           "'\       /'"_.-~^`'-.
              \  _  /--'         `
            ___)( )(___
           (((__) (__)))
   高山仰止,景行行止.虽不能至,心向往之。
*/

import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: demo
 * @description: IO密集型自定义线程池
 * @author: youyi
 * @create: 2020/9/9
 **/
@Slf4j
public class IoThreadPoolExecutor extends ThreadPoolExecutor {


    private TimeUnit timeUnit;

    public IoThreadPoolExecutor(int corePoolSize,
                         int maximumPoolSize,
                         long keepAliveTime,
                         TimeUnit unit,
                         BlockingQueue<Runnable> workQueue,
                         ThreadFactory threadFactory,
                         RejectedExecutionHandler handler)
    {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        this.timeUnit = unit;
    }

    @Override
    public void shutdown() {
        // 线程池将要关闭事件,此方法会等待线程池中正在执行的任务和队列中等待的任务执行完毕再关闭
        monitor("ThreadPool will be shutdown:");
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        // 线程池立即关闭事件,此方法会立即关闭线程池,但是会返回队列中等待的任务
        monitor("ThreadPool going to immediately be shutdown:");
        // 记录被丢弃的任务, 暂时只记录日志, 后续可根据业务场景做进一步处理
        List<Runnable> dropTasks = null;
        try {
            dropTasks = super.shutdownNow();
            log.error(MessageFormat.format("ThreadPool discard task count:{0}", dropTasks.size()));
        } catch (Exception e) {
            log.error("ThreadPool shutdownNow error", e);
        }
        return dropTasks;
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        // 监控线程池运行时的各项指标
        monitor("ThreadPool monitor data:");
    }

    @Override
    protected void afterExecute(Runnable r, Throwable ex) {
        if (ex != null) { // 监控线程池中的线程执行是否异常
            log.error("unknown exception caught in ThreadPool afterExecute:", ex);
        }
    }

    /**
     * 监控线程池运行时的各项指标, 比如:任务等待数、任务异常信息、已完成任务数、核心线程数、最大线程数等<p>
     */
    private void monitor(String title){
        try {
            // 线程池监控信息记录, 这里需要注意写ES的时机,尤其是多个子线程的日志合并到主流程的记录方式
            String threadPoolMonitor = MessageFormat.format(
                    "{0}{1}core pool size:{2}, current pool size:{3}, queue wait size:{4}, active count:{5}, completed task count:{6}, " +
                            "task count:{7}, largest pool size:{8}, max pool size:{9}, keep alive time:{10}, is shutdown:{11}, is terminated:{12}, " +
                            "thread name:{13}{14}",
                    System.lineSeparator(), title, this.getCorePoolSize(), this.getPoolSize(),
                    this.getQueue().size(), this.getActiveCount(), this.getCompletedTaskCount(), this.getTaskCount(), this.getLargestPoolSize(),
                    this.getMaximumPoolSize(), this.getKeepAliveTime(timeUnit != null ? timeUnit : TimeUnit.SECONDS), this.isShutdown(),
                    this.isTerminated(), Thread.currentThread().getName(), System.lineSeparator());
            log.info(threadPoolMonitor);
        } catch (Exception e) {
            log.error("ThreadPool monitor error", e);
        }
    }
}
