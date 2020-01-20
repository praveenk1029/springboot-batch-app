package com.practice.springbootbatchapp.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

    //@Scheduled(cron = "* */5 * * * *", fixedDelay = 60000)
    @Scheduled(fixedDelay = (3*60000))
    public String scheduleProductJob(){
        JobParameters jobParameters =
                new JobParametersBuilder().addLong("time", System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution = null;
        try {
            jobExecution = jobLauncher.run(job, jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobRestartException |JobInstanceAlreadyCompleteException
                | JobParametersInvalidException e) {
            e.printStackTrace();
        }
        //System.out.println("Product Job Status::::"+jobExecution.getStatus());
        return "Product Job Status::::"+jobExecution.getStatus();
    }

}
