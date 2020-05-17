package com.zcf.threadmodule.one.define;

import java.util.concurrent.*;

public class CallableDefine implements Callable<String> {
    @Override
    public String call() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "result from callable";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(new CallableDefine());
        System.out.println("main");
        System.out.println(result.get());
        executorService.shutdown();
    }
}
