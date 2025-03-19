package com.lukasz2.SpringBootEcomLearnApp.Config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AppConfig implements AsyncConfigurer {
    private ThreadPoolExecutor poolExecutor;

    @Autowired
    private DefaultAsyncUncaughtExceptionHandler asyncUncaughtExceptionHandler;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler(){
        return this.asyncUncaughtExceptionHandler;
    }


    @Override
    public synchronized Executor getAsyncExecutor(){
        if(poolExecutor == null){
            int minPoolSize = 2;
            int maxPoolSize = 4;
            int queueSize = 3;
            poolExecutor = new ThreadPoolExecutor(minPoolSize,maxPoolSize,1, TimeUnit.HOURS,new ArrayBlockingQueue<>(queueSize),new CustomThreadFactory());
        }
        return poolExecutor;
    }
    private class CustomThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        @Override
        public Thread newThread(Runnable r) {
           Thread th = new Thread(r);
           th.setName("MyThread-" + threadNumber.getAndIncrement());
           return th;
        }
    }
//    @Bean
//    public Executor myThreadPoolExecutor(){
//        int minPoolSize = 2;
//        int maxPoolSize = 4;
//        int queueSize = 3;
//
//        ThreadPoolTaskExecutor poolExecutor = new ThreadPoolTaskExecutor();
//        poolExecutor.setCorePoolSize(minPoolSize);
//        poolExecutor.setMaxPoolSize(maxPoolSize);
//        poolExecutor.setQueueCapacity(queueSize);
//        poolExecutor.setThreadNamePrefix("MyThread-");
//        poolExecutor.initialize();
//        return poolExecutor;
//    }


}
