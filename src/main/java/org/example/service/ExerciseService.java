package org.example.service;

import org.example.model.ExerciseList;
import org.example.repository.ExerciseData;

import java.util.Random;

public class ExerciseService {

    private final ExercisePerform exercisePerform;
    private final ExerciseData exerciseData;

    Random random = new Random();
    private double choice;

    public ExerciseService(ExercisePerform exercisePerform, ExerciseData exerciseData){
        this.exercisePerform = exercisePerform;
        this.exerciseData = exerciseData;
    }

    public void train(ExerciseList exerciseList){
        choice = random.nextDouble() + 0.57;

        if(choice >= 1){
            exercisePerform.increaseLevel(exerciseList);
            exerciseData.save();
        }
        else{
            exercisePerform.decreaseLevel(exerciseList);
            exerciseData.save();
        }
    }
}
