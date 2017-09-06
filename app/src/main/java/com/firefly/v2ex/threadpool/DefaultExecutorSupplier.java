package com.firefly.v2ex.threadpool;

import android.os.Process;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 9/5/17.
 */

public class DefaultExecutorSupplier {

    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();

    private final ThreadPoolExecutor mForBackgroudTasks;

    private final ThreadPoolExecutor mForLightWeightBackgroundTasks;

    private final Executor mMainThreadExecutor;

    private final PriorityThreadPoolExecutor mPriorityThreadExecutor;

    private static DefaultExecutorSupplier sInstance;

    public static DefaultExecutorSupplier getsInstance() {
        if (sInstance == null) {
            synchronized (DefaultExecutorSupplier.class) {
                sInstance = new DefaultExecutorSupplier();
            }
        }
        return sInstance;
    }

    private DefaultExecutorSupplier() {
        ThreadFactory backgroundPriorityThreadFactory = new
                PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);

        mForBackgroudTasks = new ThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                backgroundPriorityThreadFactory
        );

        mForLightWeightBackgroundTasks = new ThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(),
                backgroundPriorityThreadFactory
        );

        mMainThreadExecutor = new MainThreadExecutor();

        mPriorityThreadExecutor = new PriorityThreadPoolExecutor(
                NUMBER_OF_CORES * 2,
                NUMBER_OF_CORES * 2,
                60L,
                TimeUnit.SECONDS,
                backgroundPriorityThreadFactory
        );
    }

    public ThreadPoolExecutor getmForBackgroudTasks() {
        return mForBackgroudTasks;
    }

    public ThreadPoolExecutor getmForLightWeightBackgroundTasks() {
        return mForLightWeightBackgroundTasks;
    }

    public Executor getmMainThreadExecutor() {
        return mMainThreadExecutor;
    }

    public PriorityThreadPoolExecutor getmPriorityThreadExecutor() {
        return mPriorityThreadExecutor;
    }
}
