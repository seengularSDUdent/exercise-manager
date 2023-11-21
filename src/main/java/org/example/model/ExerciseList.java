package org.example.model;

import java.util.Arrays;

public class ExerciseList {

    private int[] exerciseList;
    private int pivot;

    public ExerciseList(int value){
        this.exerciseList = new int[value];
        this.pivot = 0;
    }

    public int getPivot(){
        return pivot;
    }

    public int getValueOf(int index){
        return exerciseList[index];
    }

    public void setValue(int value, int index){
        exerciseList[index] = value;
    }

    public void nextPivot(){
        if(pivot < exerciseList.length - 1){
            pivot = pivot + 1;
        }
        else{
            pivot = 0;
        }
    }

    public void prevPivot(){
        if(pivot > 0){
            pivot = pivot - 1;
        }
        else{
            pivot = exerciseList.length - 1;
        }
    }

    @Override
    public String toString(){
        return Arrays.toString(exerciseList);
    }
}
