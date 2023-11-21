package org.example.config;

import org.example.aspect.LogAspect;
import org.example.repository.ExerciseData;
import org.example.service.ExercisePerform;
import org.example.service.ExerciseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"org.example.service", "org.example.repository"})
@EnableAspectJAutoProxy
public class SpringConfiguration {

    @Bean
    ExerciseService exerciseService(ExercisePerform exercisePerform, ExerciseData exerciseData){
        ExerciseService exerciseService = new ExerciseService(exercisePerform, exerciseData);

        return  exerciseService;
    }

    @Bean
    LogAspect logAspect(){
        LogAspect logAspect = new LogAspect();

        return  logAspect;
    }
}
