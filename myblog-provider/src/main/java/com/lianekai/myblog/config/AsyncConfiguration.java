package com.lianekai.myblog.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * 异步线程配置类
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/04/09 00:19
 */
@Configuration
@EnableAsync
public class AsyncConfiguration {

    @Bean("asyncExecutor")
    public Executor asyncExecutor() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("asyncExecutor-%d").build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(2048), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return TtlExecutors.getTtlExecutorService(threadPoolExecutor);
    }
}
