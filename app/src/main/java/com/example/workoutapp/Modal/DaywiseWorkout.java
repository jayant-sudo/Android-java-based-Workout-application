package com.example.workoutapp.Modal;

public class DaywiseWorkout {
    private String day;
    private String exercise;
    private String click;

    public DaywiseWorkout(String day, String exercise, String click) {
        this.day = day;
        this.exercise = exercise;
        this.click = click;
    }

    public DaywiseWorkout() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getExercise() {
        return exercise;
    }

    public void setExercise(String exercise) {
        this.exercise = exercise;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }
}
