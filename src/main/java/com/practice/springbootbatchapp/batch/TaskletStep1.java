package com.practice.springbootbatchapp.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

import java.io.File;
@Component
public class TaskletStep1 implements Tasklet {
    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        File file = new File("C:/Users/prave/Desktop/SpringBootProjects/springboot-batch-app/src/main/resources/products.csv");
        if(file.delete())
            System.out.println("File deleted successfully....");
        else
            System.out.println("File deletion failed....");

        return null;
    }
}
