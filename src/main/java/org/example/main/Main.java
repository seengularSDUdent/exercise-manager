package org.example.main;

import org.example.config.SpringConfiguration;
import org.example.model.ExerciseList;
import org.example.service.ExerciseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        ExerciseList exerciseList = new ExerciseList(5);

        ExerciseService exerciseService = context.getBean(ExerciseService.class);

        for (int i = 0; i < 47; i++){
            exerciseService.train(exerciseList);
        }

    }
}