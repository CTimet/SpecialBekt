package io.github.ctimet.specialbekt.plugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * specialbekt的异步任务类
 */
public class PluginTask {
    private static final ThreadPoolExecutor fixedThreadPool = (ThreadPoolExecutor) Executors.newFixedThreadPool(16);
    private static final ThreadPoolExecutor cachedThreadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    public static void runTaskInFixedThreadPool(Runnable task) {
        fixedThreadPool.submit(task);
    }
    public static void runTaskInCachedThreadPool(Runnable task) {
        cachedThreadPool.submit(task);
    }
    public static int getThreadPoolQueueSize() {
        return fixedThreadPool.getQueue().size();
    }
}
