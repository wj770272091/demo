package com.example.demo.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @NAME: CsvJobListener
 * @USER: 77027
 * @DATE: 2021/1/5
 * @TIME: 9:48
 */
public class CsvJobListener implements JobExecutionListener {
    long startTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束");
        System.out.println("耗时:"+(endTime - startTime) + "ms");
    }
}
