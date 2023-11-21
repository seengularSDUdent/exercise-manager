package org.example.service;

import org.example.model.ExerciseList;
import org.springframework.stereotype.Service;

@Service
public class SampleExercisePerform implements ExercisePerform{

    private int totalAction;
    private boolean wasNext;
    private boolean wasPrev;

    public SampleExercisePerform(){
        totalAction = 0;
        wasNext = false;
        wasPrev = false;
    }
    @Override
    public void increaseLevel(ExerciseList exerciseList) {

        if(totalAction >= 0){
            if(wasNext){
                exerciseList.nextPivot();
            }

            int index = exerciseList.getPivot();
            int value = exerciseList.getValueOf(index) + 1;
            exerciseList.setValue(value, index);
            wasNext = true;
            wasPrev = false;

            totalAction++;
        }
    }

    @Override
    public void decreaseLevel(ExerciseList exerciseList) {

        if(totalAction > 0){
            if(wasPrev){
                exerciseList.prevPivot();
            }

            int index = exerciseList.getPivot();
            int value = exerciseList.getValueOf(index) - 1;
            exerciseList.setValue(value, index);
            wasPrev = true;
            wasNext = false;

            totalAction--;
        }
    }
}
